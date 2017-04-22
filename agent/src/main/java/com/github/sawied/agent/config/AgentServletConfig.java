package com.github.sawied.agent.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages={"com.github.sawied.agent.web"})
@ImportResource(value={"classpath:sawied/agent/config/application-context.xml"})
public class AgentServletConfig extends WebMvcConfigurerAdapter{

   
    
    
    @Bean
    public CommonsMultipartResolver multipartResolver(){
	CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
	return commonsMultipartResolver;
    }
    
    
    
    
}
