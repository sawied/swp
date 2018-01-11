package com.github.sawied.microservice.oauth2.client.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@Configuration
@EnableOAuth2Client
@PropertySource({"classpath:sawied/microservice/client/apis/config/authorization-oauth2-urls.properties"})
public class Oauth2ClientSecurityConfig {
	
	@Value("${accessTokenUri}")
	private String accessTokenUri;
	
	
	@Value("${userAuthorizationUri}")
	private String userAuthorizationUri;
	
	@Bean
	public OAuth2ProtectedResourceDetails resourceService() {
		AuthorizationCodeResourceDetails details = new AuthorizationCodeResourceDetails();
		details.setId("sawied-resource");
		details.setClientId("api-gateway");
		details.setClientSecret("secret");
		details.setAccessTokenUri(accessTokenUri);
		details.setUserAuthorizationUri(userAuthorizationUri);
		details.setScope(Arrays.asList("read", "write"));
		details.setUseCurrentUri(true);
		return details;
	}
	
	@Bean
	public OAuth2RestTemplate oauth2RestTemplate(OAuth2ClientContext clientContext) {
		return new OAuth2RestTemplate(resourceService(), clientContext);
	}
	
	
	@Bean
	public OAuth2RestTemplate trustOauth2RestTemplate(OAuth2ClientContext clientContext) {
		return new OAuth2RestTemplate(trustResourceService(), clientContext);
	}
	
	
	@Bean
	public OAuth2ProtectedResourceDetails trustResourceService() {
		AuthorizationCodeResourceDetails details = new AuthorizationCodeResourceDetails();
		details.setId("sawied-resource");
		details.setClientId("api-gateway");
		details.setClientSecret("secret");
		details.setAccessTokenUri(accessTokenUri);
		details.setUserAuthorizationUri(userAuthorizationUri);
		details.setScope(Arrays.asList("read", "write"));
		details.setUseCurrentUri(true);
		details.setGrantType("password");
		return details;
		
	}

}
