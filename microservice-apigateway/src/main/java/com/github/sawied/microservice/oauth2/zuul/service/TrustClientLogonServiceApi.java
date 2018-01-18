package com.github.sawied.microservice.oauth2.zuul.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trust")
public class TrustClientLogonServiceApi {
	
	@Autowired
	@Qualifier("trustOauth2RestTemplate")
	private OAuth2RestTemplate restTemplate;
	
	
	@RequestMapping("login")
	public Map<String,?> trustClientSignin(){
		OAuth2AccessToken token = restTemplate.getAccessToken();
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("additionInfo", token.getAdditionalInformation());
		map.put("expiration", token.getExpiration());
		map.put("accessToken", token.getValue());
		map.put("refreshToken", token.getRefreshToken());
		return map;
	}
	
	
}
