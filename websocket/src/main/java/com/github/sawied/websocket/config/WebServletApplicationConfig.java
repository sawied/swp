package com.github.sawied.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ImportResource(locations={"classpath:sawied/github/websocket/websocket-context.xml"})
public class WebServletApplicationConfig  extends WebMvcConfigurerAdapter{

	@Override
	public Validator getValidator() {
		return super.getValidator();
	}

	
	
}
