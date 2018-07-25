package com.github.sawied.docker.apis;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeCotroller {

	
	@RequestMapping("/users/{ids}")
	public String appInfo(String id) {
		return id;
	}
	
	
}
