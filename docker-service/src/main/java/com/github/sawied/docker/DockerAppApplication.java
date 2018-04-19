package com.github.sawied.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;


@SpringBootApplication
public class DockerAppApplication extends SpringBootServletInitializer implements WebApplicationInitializer{

	
	  @Override
		protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
			return builder.sources(DockerAppApplication.class);
		}

	public static void main(String[] args) {
		SpringApplication.run(DockerAppApplication.class, args);
	}
}
