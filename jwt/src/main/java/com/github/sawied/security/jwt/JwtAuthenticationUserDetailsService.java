package com.github.sawied.security.jwt;

import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


/**
 * 
 * Simply , provides dummy user detail service.
 * 
 * @author James X W Zhang
 *
 */
public class JwtAuthenticationUserDetailsService implements AuthenticationUserDetailsService<CiphertextAuthenticationToken>{

	@Override
	public UserDetails loadUserDetails(CiphertextAuthenticationToken token) throws UsernameNotFoundException {
		return new JwtUserDetails(token.getName(),"N/A",Collections.<GrantedAuthority>emptySet());
	}

}
