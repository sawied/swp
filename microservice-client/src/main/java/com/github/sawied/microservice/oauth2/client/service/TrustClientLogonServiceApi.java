package com.github.sawied.microservice.oauth2.client.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trust")
public class TrustClientLogonServiceApi {

	

	
	@Autowired
	private OAuth2RestTemplate restTemplate;
	
	
	@RequestMapping("login")
	public Map<String,?> trustClientSignin(){
		OAuth2AccessToken token = restTemplate.getAccessToken();
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("additionInfo", token.getAdditionalInformation());
		map.put("expiration", token.getExpiration());
		return map;
	}
	
	
}
