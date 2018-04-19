package com.github.sawied.jweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;


@SpringBootApplication
public class JwebServiceApplication extends SpringBootServletInitializer implements WebApplicationInitializer{

	
	  @Override
		protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
			return builder.sources(JwebServiceApplication.class);
		}

	
	public static void main(String[] args) {
		SpringApplication.run(JwebServiceApplication.class, args);
	}
}
