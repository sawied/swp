package com.github.sawied.microservice.authorization.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.ClientDetailsUserDetailsService;

@Configuration
@EnableWebSecurity(debug = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService clientDetailsUserDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(clientDetailsUserDetailsService).and().inMemoryAuthentication().withUser("danan")
				.password("danan").authorities("ROLE_USER", "ROLE_READ", "ROLE_WRITE").and().withUser("mvtm")
				.password("password").authorities("ROLE_USER", "ROLE_READ", "ROLE_WRITE").and().and()
				.eraseCredentials(false);
	}

	@Bean
	public UserDetailsService clientDetailsUserDetailsService(ClientDetailsService clientDetailsService) {
		return new ClientDetailsUserDetailsService(clientDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// super.configure(http);
		http.requestMatchers().antMatchers("/login","/login.html", "/logout","/oauth/authorize").and().authorizeRequests()
				.antMatchers("/login.html", "/login").permitAll().and().formLogin().loginPage("/login.html")
				.loginProcessingUrl("/login").failureUrl("/login.html?authentication_error=true").and().logout()
				.logoutUrl("/logout").logoutSuccessUrl("/logout.html").and().csrf().disable().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED).and().httpBasic()
				.realmName("authorizationServer");

	}

	/**
	 * export authentication manager object for password grant model
	 */
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

}
