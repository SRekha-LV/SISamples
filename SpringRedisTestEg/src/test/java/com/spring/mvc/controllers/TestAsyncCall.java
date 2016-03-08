package com.spring.mvc.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import com.spring.mvc.config.SpringConfig;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={SpringConfig.class})
@WebAppConfiguration
public class TestAsyncCall {
	
	private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext webApplicationContext;
	
	@Before
	public void setup () {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	
	@Test
	public void test_checkStatus () throws Exception {
		String strURL = "/";
		
		MockHttpServletRequestBuilder  mockHttpServletRequestBuilder = get(strURL)
				.accept(MediaType.APPLICATION_JSON)			
				.contentType(MediaType.APPLICATION_JSON);
				
		 MvcResult mvcResult = mockMvc.perform(mockHttpServletRequestBuilder)
				.andExpect(request ().asyncStarted())		
				.andReturn();
		 
		 mvcResult.getAsyncResult();
		 
		mockMvc.perform(asyncDispatch(mvcResult))
		.andDo(print ())
        .andExpect(status().isOk());
	}

}
