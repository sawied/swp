package com.github.sawied.microservice.authorization.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginPageController {

	@RequestMapping(path="/login.html")
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping("/oauth/error")
	public String handleError(Map<String, Object> model) throws Exception {
		// We can add more stuff to the model here for JSP rendering. If the client was a machine then
		// the JSON will already have been rendered.
		model.put("message", "There was a problem with the OAuth2 protocol");
		return "oauth_error";
	}
	
	
}
