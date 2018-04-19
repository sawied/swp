package com.github.sawied.docker.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("file:${user.home}/mvtm/${spring.application.name}/appconfig.properties")
public class WebConfig {

}
