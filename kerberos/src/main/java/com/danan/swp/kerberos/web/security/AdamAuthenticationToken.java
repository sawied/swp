package com.danan.swp.kerberos.web.security;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class AdamAuthenticationToken extends AbstractAuthenticationToken {


	private static final long serialVersionUID = 6041285537660386680L;

	public AdamAuthenticationToken(
			Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
	}

	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return null;
	}

}
