package com.spring.mvc.redis;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.redis.outbound.RedisQueueOutboundChannelAdapter;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.mvc.config.AppRedisConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppRedisConfig.class})
public class TestHitCount {
	
	@Autowired
	RedisQueueOutboundChannelAdapter rulesRQOutboundChannelAdapter;
	
	@Captor
	ArgumentCaptor<Message<Object>> captor;
	
	@Before
	public void setUp () {
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void testProcessQueue1 () {
		ProcessQueue1Messages pQueue1Msgs = Mockito.mock(ProcessQueue1Messages.class);
		Object strObj = "TEst";
		Message<Object> message = MessageBuilder.withPayload(strObj).build();
		rulesRQOutboundChannelAdapter.handleMessage(message);
		
		Mockito.verify(pQueue1Msgs).processQueue1Details(message);
	}
}
