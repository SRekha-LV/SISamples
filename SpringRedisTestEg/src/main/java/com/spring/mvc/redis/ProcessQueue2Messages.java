package com.spring.mvc.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.redis.outbound.RedisQueueOutboundChannelAdapter;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@MessageEndpoint
public class ProcessQueue2Messages {
	
	@Autowired
	RedisQueueOutboundChannelAdapter dbOptsRQOutboundChannelAdapter; 
	
	@Autowired
	RedisQueueOutboundChannelAdapter mailRQOutboundChannelAdapter; 

	@ServiceActivator (inputChannel = "actionsQueueChannel",poller = @Poller(fixedDelay="10", taskExecutor="actionExecutor"))
	public void processQueue2Details (Message<Object> strMsg) {
		System.out.println("....newMsg:2" );
		try {
			dbOptsRQOutboundChannelAdapter.handleMessage(MessageBuilder.withPayload(strMsg.getPayload()).build ());
			mailRQOutboundChannelAdapter.handleMessage(MessageBuilder.withPayload(strMsg.getPayload()).build ());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
