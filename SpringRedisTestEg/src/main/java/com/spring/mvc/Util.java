package com.spring.mvc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.context.request.async.DeferredResult;

public class Util {
	
	public static final Map<Integer, DeferredResult<String >> defRequestsMap = new ConcurrentHashMap<Integer, DeferredResult<String>>();

}
