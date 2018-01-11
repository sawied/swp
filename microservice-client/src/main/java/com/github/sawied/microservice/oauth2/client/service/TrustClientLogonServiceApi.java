package com.github.sawied.microservice.oauth2.client.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trust")
public class TrustClientLogonServiceApi {

	
	public static final String CLIENT_HEADER ="X-Client-Info";
	
	@Autowired
	@Qualifier("trustOauth2RestTemplate")
	private OAuth2RestTemplate restTemplate;
	
	
	@RequestMapping("login")
	public Map<String,?> trustClientSignin(@RequestHeader(CLIENT_HEADER) String clientInfo){
		Assert.hasText(clientInfo, "encrpted client info can't empty");
		return null;
	}
	
	
}
