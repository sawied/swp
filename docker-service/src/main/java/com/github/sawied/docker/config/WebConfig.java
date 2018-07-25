package com.github.sawied.docker.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:github/sawied/dockerapp/appconfig.properties")
public class WebConfig {

}
