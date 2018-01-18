package com.github.sawied.microservice.oauth2.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
@Import(Oauth2ClientSecurityConfig.class)
@ComponentScan(basePackages= {"com.github.sawied.microservice.oauth2.client.service"})
public class Oauth2ClientServletConfig extends WebMvcConfigurerAdapter{

	
	@Bean public RequestContextListener requestContextListener(){
	    return new RequestContextListener();
	} 
}
