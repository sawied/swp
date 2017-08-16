package com.github.sawied.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

//@EnableAutoConfiguration
@Configuration
@ImportResource(locations={"classpath:sawied/github/websocket/websocket-context.xml"})
public class WebsocketAppConfig {
	
}
