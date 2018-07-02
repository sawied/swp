package com.github.sawied.microservice.authorization.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2RequestFactory;
import org.springframework.security.oauth2.provider.approval.TokenStoreUserApprovalHandler;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class OauthSecurityAuthorizationConfig {
	
	@Bean
	public ClientDetailsService clientDetailsService() throws Exception {
		InMemoryClientDetailsServiceBuilder clientDetailsBuilder=new InMemoryClientDetailsServiceBuilder();
		clientDetailsBuilder.withClient("api-gateway").autoApprove(true)
		.authorities("ROLE_CLIENT").authorizedGrantTypes("authorization_code", "refresh_token", "password")
		.resourceIds("sawied-resource").scopes("read", "write", "user").secret("secret").and()
		.withClient("sawied-client").secret("sawied-1990").authorities("ROLE_RESOURCE");
		return clientDetailsBuilder.build();
	}
	
	

	@Configuration
	@EnableAuthorizationServer
	static class customAuthorizationServerConfigurer extends AuthorizationServerConfigurerAdapter {

		@Autowired
		private TokenStore tokenStore;

		@Autowired
		private UserApprovalHandler userApprovalHandler;

		@Autowired
		private ClientDetailsService clientDetailsService;
		
		@Autowired
		private AuthenticationManager authenticationManager;

		@Bean
		public TokenStore tokenStore() {
			//JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
			//jwtAccessTokenConverter.setSigningKey("secert");
			//return new JwtTokenStore(jwtAccessTokenConverter);
			return new InMemoryTokenStore();
		}

		@Bean
		public OAuth2RequestFactory requestFactory(ClientDetailsService clientDetailsService) {
			OAuth2RequestFactory requestFactory = new DefaultOAuth2RequestFactory(clientDetailsService);
			return requestFactory;
		}

		@Bean
		public UserApprovalHandler userApprovalHandler(OAuth2RequestFactory requestFactory,ClientDetailsService clientDetailsService) {
			TokenStoreUserApprovalHandler UserApprovalHandler = new TokenStoreUserApprovalHandler();
			UserApprovalHandler.setClientDetailsService(clientDetailsService);
			UserApprovalHandler.setRequestFactory(requestFactory);
			UserApprovalHandler.setTokenStore(tokenStore);
			return UserApprovalHandler;
		}
		

		@Override
		public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
			clients.withClientDetails(clientDetailsService);
		}

		/**
		 * if authentication manager object is present,then spring oauth2 security framework will enable the feather of password grant. 
		 */
		@Override
		public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
			endpoints.tokenStore(tokenStore).userApprovalHandler(userApprovalHandler).authenticationManager(authenticationManager);
			
		}

		@Override
		public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
			security.allowFormAuthenticationForClients().checkTokenAccess("isAuthenticated()");
		}
		
	}
	
	
	
	@Configuration
	@EnableResourceServer
	protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

		@Override
		public void configure(ResourceServerSecurityConfigurer resources) {
			resources.resourceId("sawied-resource").stateless(true);
		}

		@Override
		public void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().antMatchers("/**").access("hasRole('USER')").and().csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
			;
		}
		
		
	}
	

}
