package com.github.sawied.microservice.oauth2.client.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoRestTemplateFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.util.Assert;

@Configuration
@EnableOAuth2Client
@EnableOAuth2Sso
@EnableWebSecurity
@PropertySource({ "classpath:sawied/microservice/client/apis/config/authorization-oauth2-urls.properties" })
public class Oauth2ClientSecurityConfig extends WebSecurityConfigurerAdapter{

	@Value("${accessTokenUri}")
	private String accessTokenUri;

	@Value("${userAuthorizationUri}")
	private String userAuthorizationUri;

	public static final String CLIENT_HEADER = "X-Client-Info";


	
	@Bean
	@Primary
	public OAuth2ProtectedResourceDetails resourceService() {
		AuthorizationCodeResourceDetails details = new AuthorizationCodeResourceDetails();
		details.setId("sawied-resource");
		details.setClientId("api-gateway");
		details.setClientSecret("secret");
		details.setAccessTokenUri(accessTokenUri);
		details.setUserAuthorizationUri(userAuthorizationUri);
		details.setScope(Arrays.asList("read", "write","user"));
		details.setUseCurrentUri(true);
		return details;
	}

	@Bean
	public OAuth2RestTemplate oauth2RestTemplate(OAuth2ClientContext clientContext) {
		return new OAuth2RestTemplate(resourceService(), clientContext);
	}
	
	
	@Bean
	public AccessTokenProvider userAccessTokenProvider() {
		ResourceOwnerPasswordAccessTokenProvider accessTokenProvider = new ResourceOwnerPasswordAccessTokenProvider();
		return accessTokenProvider;
	}
	
	@Bean
	public UserInfoRestTemplateFactory userInfoRestTemplateFactory(@Autowired  final OAuth2RestTemplate trustOauth2RestTemplate) {
		return new UserInfoRestTemplateFactory(){

			@Override
			public OAuth2RestTemplate getUserInfoRestTemplate() {
				
				return trustOauth2RestTemplate;
			}
			
		};
	}
	
	
	
	/**
	@Bean
	public OAuth2RestTemplate trustOauth2RestTemplate(
			@Qualifier("trustResourceService") OAuth2ProtectedResourceDetails trustResourceService,OAuth2ClientContext clientContext) {
		OAuth2RestTemplate ort = new OAuth2RestTemplate(trustResourceService, clientContext);
		ort.setAccessTokenProvider(new ResourceOwnerPasswordAccessTokenProvider());
		return ort;
	}


	@Bean
	@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value = "request")
	public ResourceOwnerPasswordResourceDetails trustResourceService(
			@Value("#{request.getHeader('" + CLIENT_HEADER + "')}") String username) {
		//Assert.hasText(username, "client info must be present in headers of " + CLIENT_HEADER);
		ResourceOwnerPasswordResourceDetails details = new ResourceOwnerPasswordResourceDetails();
		details.setId("sawied-resource");
		details.setClientId("api-gateway");
		details.setClientSecret("secret");
		details.setAccessTokenUri(accessTokenUri);
		details.setScope(Arrays.asList("read", "write"));
		details.setGrantType("password");
		details.setUsername(username);
		details.setPassword("password");
		return details;

	}
	**/

	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);
		web.debug(true);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http
	        .logout().logoutSuccessUrl("/").and().formLogin().and()
	            .authorizeRequests()
	                .antMatchers("/index.html", "/app.html", "/", "/login","/trust/**").permitAll()
	                .anyRequest().authenticated().and().csrf().disable()
	             ;
	            // @formatter:on
	}


}
