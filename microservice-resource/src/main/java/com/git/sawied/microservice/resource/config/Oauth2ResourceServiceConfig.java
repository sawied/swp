package com.git.sawied.microservice.resource.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@Configuration
@EnableWebSecurity
@EnableResourceServer
public class Oauth2ResourceServiceConfig extends ResourceServerConfigurerAdapter{

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.resourceId("sawied-resource-service");
	}
	
	
	
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		super.configure(http);
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
	}




	@Bean
	public ResourceServerTokenServices tokenService() {
		RemoteTokenServices tokenService = new RemoteTokenServices();
		tokenService.setCheckTokenEndpointUrl("http://localhost:8888/microservice-authorization-SNAPSHOT/oauth/check_token");
		tokenService.setClientId("sawied-user-resource");
		tokenService.setClientSecret("sawied-1990");
		return tokenService;
	}

	
	
}
