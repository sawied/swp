package com.github.sawied.jwt.security;


import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;


/**
 * 
 * @author James X W Zhang
 *
 */
public class CiphertextAuthenticationToken extends AbstractAuthenticationToken{

	private static final long serialVersionUID = 8465243020840094853L;
	
	private final Object principal;
	private final Object credentials;


	public CiphertextAuthenticationToken( Object principal,
			Object credentials) {
		super(null);
		this.principal = principal;
		this.credentials = credentials;
	}
	
	
	
	
	

	public CiphertextAuthenticationToken(Collection<? extends GrantedAuthority> authorities, Object principal,
			Object credentials) {
		super(authorities);
		this.principal = principal;
		this.credentials = credentials;
		setAuthenticated(true);
	}


	@Override
	public Object getCredentials() {
		return this.credentials;
	}

	@Override
	public Object getPrincipal() {
		return this.principal;
	}

}
