package com.github.sawied.microservice.oauth2.zuul;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityFilterAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication(exclude= {SecurityAutoConfiguration.class,SecurityFilterAutoConfiguration.class})
@EnableZuulProxy
@EnableOAuth2Client
public class ZuulGatewayApplication extends SpringBootServletInitializer implements WebApplicationInitializer {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ZuulGatewayApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ZuulGatewayApplication.class);
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
	}

}
