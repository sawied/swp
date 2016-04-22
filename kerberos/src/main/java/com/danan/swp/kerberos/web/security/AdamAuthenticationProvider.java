package com.danan.swp.kerberos.web.security;

import java.util.Collections;
import java.util.Set;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class AdamAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		GrantedAuthority ga=new SimpleGrantedAuthority("PSWPUse");
		Set<GrantedAuthority> set = Collections.emptySet();
		set.add(ga);
		return new AdamAuthenticationToken(set);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return PreAuthenticatedAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
