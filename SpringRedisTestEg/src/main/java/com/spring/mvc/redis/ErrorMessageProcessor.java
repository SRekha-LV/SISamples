package com.spring.mvc.redis;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;

@MessageEndpoint
public class ErrorMessageProcessor {
	
	@ServiceActivator (inputChannel = "errorChannel",poller = @Poller(fixedDelay="10"))
	public void processQueue1Details (Message<Object> strMsg) {
		System.out.println("...... *********** Errors: " + strMsg.getPayload());
		
	}

}
