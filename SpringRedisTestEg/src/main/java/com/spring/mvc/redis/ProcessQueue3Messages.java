package com.spring.mvc.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.redis.outbound.RedisQueueOutboundChannelAdapter;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@MessageEndpoint
public class ProcessQueue3Messages {
	
	@Autowired
	RedisQueueOutboundChannelAdapter mailRQOutboundChannelAdapter; 

	@ServiceActivator (inputChannel = "dbQueueChannel",poller = @Poller(fixedDelay="10", taskExecutor="dbServiceExecutor"))
	public void processQueue3Details (Message<Object> strMsg) {
		System.out.println("....newMsg: 3" );
//		mailRQOutboundChannelAdapter.handleMessage(MessageBuilder.withPayload(strMsg.getPayload()).build ());
	}
}
