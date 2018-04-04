package com.github.sawied.docker.apis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeCotroller {

	@Value("${loan.path}")
	private String templatePath;
	
	@Value("${user.home}")
	private String home;
	
	@Value("${foo}")
	private String foo;
	
	@RequestMapping("/")
	public String appInfo() {
		return "current payh:"+templatePath+" home: " + home +" foo:" + foo;
	}
	
	
}
