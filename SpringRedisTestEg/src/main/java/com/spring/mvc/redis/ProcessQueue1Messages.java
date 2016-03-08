package com.spring.mvc.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.redis.outbound.RedisQueueOutboundChannelAdapter;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@MessageEndpoint
public class ProcessQueue1Messages implements Queue1Messages{
	
	@Autowired
	RedisQueueOutboundChannelAdapter actionRQOutbounChannelAdapter; 
	
	@Override
	@ServiceActivator (inputChannel = "rulesQueueChannel",poller = @Poller(fixedDelay="10", taskExecutor="rulesExecutor"))
	public void processQueue1Details (Message<Object> strMsg) {
		String newMsg = strMsg.getPayload() + "\nHello Queue1";
		System.out.println("....newMsg: " + newMsg);
		try {
			actionRQOutbounChannelAdapter.handleMessage(MessageBuilder.withPayload(strMsg.getPayload()).build ());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
