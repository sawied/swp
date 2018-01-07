package com.github.sawied.microservice.oauth2.client.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apis")
public class UserServiceApi {

	@Autowired
	private OAuth2RestTemplate restTemplate;
	
	@Value("${userServiceurl}")
	private String userServiceurl;
	
	@RequestMapping("/users")
	public String getUser() {
		String result =restTemplate.getForObject(URI.create(userServiceurl), String.class);
		return result;
	}
	
}
