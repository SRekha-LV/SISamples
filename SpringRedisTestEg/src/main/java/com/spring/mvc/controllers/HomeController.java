package com.spring.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.redis.outbound.RedisQueueOutboundChannelAdapter;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.spring.mvc.Util;

@RestController
public class HomeController {
	
	@Autowired
	RedisQueueOutboundChannelAdapter rulesRQOutboundChannelAdapter;
	
	static int keyInt = 0;
	
	
	
	/* @RequestMapping(value = "/")
		public String hello (Model model) {
			System.out.println("----------- In hello controller");
			String message = "From Hello Controller";
			model.addAttribute("name", "shasi");
			return "helloworld";
		}*/
	 
	 
	 
		
		@RequestMapping (value="/", method=RequestMethod.GET)
		public DeferredResult<String> executeSlowTask (Model model) {
			System.out.println("!!! Deferred Request received " + keyInt);
			final DeferredResult<String> defResult = new DeferredResult<>();
			keyInt++;
			Util.defRequestsMap.put(keyInt, defResult);
			
			defResult.onCompletion(new Runnable() {
				@Override
				public void run() {
					Util.defRequestsMap.remove(keyInt);
				}
			});
			
			try {
				model.addAttribute("name", "shasi");
				rulesRQOutboundChannelAdapter.handleMessage(MessageBuilder.withPayload(keyInt).build());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			return defResult;
		}

}
