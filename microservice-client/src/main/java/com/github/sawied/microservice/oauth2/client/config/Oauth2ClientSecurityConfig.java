package com.github.sawied.microservice.oauth2.client.config;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenProvider;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordAccessTokenProvider;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetailsSource;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationProcessingFilter;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;

@Configuration
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
	
	
	@Primary
	@Bean 
	@Qualifier("clientContext")
	@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value = "request")
	public OAuth2ClientContext clientContext(@Autowired @Qualifier("accessTokenRequest") AccessTokenRequest accessTokenRequest,HttpServletRequest httpRequest) {
		HttpSession session=httpRequest.getSession(false);
		
		String token=extractHeaderToken(httpRequest);
		if(token!=null) {
			return  new DefaultOAuth2ClientContext(new DefaultOAuth2AccessToken(token));
		}
		
		if(session!=null) {
			Object clientContext = session.getAttribute("clientContext");
			if(clientContext!=null) {
				return (OAuth2ClientContext) clientContext;
			}else{
				clientContext=new DefaultOAuth2ClientContext(accessTokenRequest);
				session.setAttribute("clientContext",clientContext);
				return (OAuth2ClientContext) clientContext;
			}
		}
		
		return new DefaultOAuth2ClientContext(accessTokenRequest);
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
	
	

	@Autowired
	private ResourceServerTokenServices resoureServerTokenServices;
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		Oauth2PreAuthenticationProcessingFilter oauth2PreAuthenticationProcessingFilter = new Oauth2PreAuthenticationProcessingFilter();
		
		OAuth2AuthenticationManager authManager = new OAuth2AuthenticationManager();
		authManager.setTokenServices(resoureServerTokenServices);
		oauth2PreAuthenticationProcessingFilter.setAuthenticationManager(authManager);
		oauth2PreAuthenticationProcessingFilter.setAuthenticationDetailsSource(new OAuth2AuthenticationDetailsSource());
		
		 http.addFilterAfter(oauth2PreAuthenticationProcessingFilter, SecurityContextPersistenceFilter.class).sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER).and()
	        .logout().logoutSuccessUrl("/").and().formLogin().and()
	            .authorizeRequests()
	                .antMatchers("/index.html", "/app.html", "/", "/login","/trust/**","/error").permitAll()
	                .anyRequest().authenticated().and().csrf().disable()
	             ;
	            // @formatter:on
	}
	
	/**
	 * Extract the OAuth bearer token from a header.
	 * 
	 * @param request The request.
	 * @return The token, or null if no OAuth authorization header was supplied.
	 */
	protected String extractHeaderToken(HttpServletRequest request) {
		Enumeration<String> headers = request.getHeaders("Authorization");
		while (headers.hasMoreElements()) { // typically there is only one (most servers enforce that)
			String value = headers.nextElement();
			if ((value.toLowerCase().startsWith(OAuth2AccessToken.BEARER_TYPE.toLowerCase()))) {
				String authHeaderValue = value.substring(OAuth2AccessToken.BEARER_TYPE.length()).trim();
				// Add this here for the auth details later. Would be better to change the signature of this method.
				request.setAttribute(OAuth2AuthenticationDetails.ACCESS_TOKEN_TYPE,
						value.substring(0, OAuth2AccessToken.BEARER_TYPE.length()).trim());
				int commaIndex = authHeaderValue.indexOf(',');
				if (commaIndex > 0) {
					authHeaderValue = authHeaderValue.substring(0, commaIndex);
				}
				return authHeaderValue;
			}
		}

		return null;
	}


}
