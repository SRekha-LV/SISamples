package com.spring.mvc.redis;

import org.springframework.messaging.Message;

public interface Queue1Messages {

//	public void processQueue1Details(Message<String> strMsg);

	public void processQueue1Details(Message<Object> strMsg);

}
