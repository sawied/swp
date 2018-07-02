package com.github.sawied.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication
@EnableEurekaServer
public class MicroserviceDiscoveryApplication extends SpringBootServletInitializer
		implements WebApplicationInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(MicroserviceDiscoveryApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceDiscoveryApplication.class, args);
	}
}
