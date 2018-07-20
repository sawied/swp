package com.github.sawied.websocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.sawied.websocket.paging.PageJsonDeserializer;

@Configuration
public class Jackson2Config {
	
	@Bean
	public PageJsonDeserializer pageJsonDeserializer() {
		return new PageJsonDeserializer();
	}
}
