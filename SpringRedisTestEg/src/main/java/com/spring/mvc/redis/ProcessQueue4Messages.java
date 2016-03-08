package com.spring.mvc.redis;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.web.context.request.async.DeferredResult;

import com.spring.mvc.Util;
import com.spring.mvc.controllers.HomeController;

@MessageEndpoint
public class ProcessQueue4Messages {
	

	@ServiceActivator (inputChannel = "mailQueueChannel",poller = @Poller(fixedDelay="10", taskExecutor="mailingServExecutor"))
	public void processQueue4Details (Message<Object> strMsg) {
//		String newMsg = strMsg.getPayload() + "\nHello Queue4";
		System.out.println("........4" + strMsg.getPayload());
		DeferredResult<String> defResult = Util.defRequestsMap.get(strMsg.getPayload());
		defResult.setResult("helloworld");
	}
}
