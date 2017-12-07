package com.danan.business.smot.integration.http;

import java.util.Map;

import org.springframework.messaging.handler.annotation.Headers;

public interface HTTPExecutor {
	
	Object execute(@Headers Map<String,Object> headers,Object payload);

}
