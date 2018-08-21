package com.github.sawied.websocket.config;

import java.io.IOException;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.Base64Utils;

public class RestTemplateHAMCAuthorizationInterceptor implements ClientHttpRequestInterceptor {
	
	
	private byte[] privateKey;
	
	private byte[] publicKey;
	
	

	public RestTemplateHAMCAuthorizationInterceptor(byte[] privateKey, byte[] publicKey) {
		super();
		this.privateKey = privateKey;
		this.publicKey = publicKey;
	}




	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		
		request.getHeaders().add("Authorization", "authenticationkey:" + "signature");
		return execution.execute(request, body);
	}

}
