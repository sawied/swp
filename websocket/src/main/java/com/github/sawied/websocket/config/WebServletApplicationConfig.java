package com.github.sawied.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
//@ImportResource(locations={"classpath:sawied/github/websocket/websocket-context.xml"})
public class WebServletApplicationConfig  extends WebMvcConfigurerAdapter{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/xhr/**").addResourceLocations("classpath:static/socketjs/");
	}

	

	
	
}
