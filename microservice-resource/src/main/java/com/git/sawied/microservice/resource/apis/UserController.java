package com.git.sawied.microservice.resource.apis;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	@RequestMapping(method=RequestMethod.GET)
	public List<String> availableUsers(){
		return Arrays.<String> asList("danan","sawied");
	}
	
	
	
}
