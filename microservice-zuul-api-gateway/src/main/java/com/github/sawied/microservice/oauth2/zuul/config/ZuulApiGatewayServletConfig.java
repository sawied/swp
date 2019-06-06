package com.github.sawied.microservice.oauth2.zuul.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.util.Assert;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages= {"com.github.sawied.microservice.oauth2.zuul.service"})
public class ZuulApiGatewayServletConfig extends WebMvcConfigurerAdapter{

	
	public static final String CLIENT_HEADER = "X-Client-Info";
	
	@Value("${trust-oauth2.access-token-url}")
	private String accessTokenUri;
	
	
	@Bean public RequestContextListener requestContextListener(){
	    return new RequestContextListener();
	}
	
	@Bean 
	@Qualifier("clientContext")
	@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value = "request")
	public OAuth2ClientContext clientContext(@Autowired @Qualifier("accessTokenRequest") AccessTokenRequest accessTokenRequest) {
		return new DefaultOAuth2ClientContext(accessTokenRequest);
	}
	
	
	@Bean
	@Qualifier("trustOauth2RestTemplate")
	public OAuth2RestTemplate trustOauth2RestTemplate(
			@Qualifier("trustResourceService") OAuth2ProtectedResourceDetails trustResourceService,
			OAuth2ClientContext clientContext) {
		OAuth2RestTemplate ort = new OAuth2RestTemplate(trustResourceService, clientContext);
		ort.setAccessTokenProvider(new ResourceOwnerPasswordAccessTokenProvider());
		return ort;
	}

	@Bean
	@Qualifier("trustResourceService")
	@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value = "request")
	public ResourceOwnerPasswordResourceDetails trustResourceService(
			@Value("#{request.getHeader('" + CLIENT_HEADER + "')}") String username) {
		Assert.hasText(username, "client info must be present in headers of " + CLIENT_HEADER);
		ResourceOwnerPasswordResourceDetails details = new ResourceOwnerPasswordResourceDetails();
		details.setId("sawied-resource");
		details.setClientId("api-gateway");
		details.setClientSecret("secret");
		details.setAccessTokenUri(accessTokenUri);
		details.setScope(Arrays.asList("read", "write","user"));
		details.setGrantType("password");
		details.setUsername("mvtm01");
		details.setPassword("password");
		return details;

	}
	
	
}
