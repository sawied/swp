package com.github.sawied.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@Order(1)
public class WebsocketApp extends SpringBootServletInitializer implements WebApplicationInitializer
{
	
    @Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(WebsocketApp.class);
	}

	public static void main( String[] args )
    {
        SpringApplication.run(WebsocketApp.class, args);
    }
}
