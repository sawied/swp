package com.danan.swp.kerberos.web.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.util.Assert;


/**
 * this class will retrieve the roles from websphere ADADM 
 * @author danan
 *
 */
public class AdamGrantedAuthoritiesUserDetailsService implements
		AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> {

	@Override
	public UserDetails loadUserDetails(PreAuthenticatedAuthenticationToken token)
			throws UsernameNotFoundException {
		Assert.notNull(token.getDetails());
		String name = token.getName();
		return createUserDatils(name);
	}
	
	protected UserDetails createUserDatils(String name) {
		Set<GrantedAuthority> set = new HashSet<GrantedAuthority>();
		set.add(new SimpleGrantedAuthority("ROLE_PSWPUser"));
		set.add(new SimpleGrantedAuthority("ROLE_authenticatedUser"));
		return new User(name, "N/A", set);
	}
	

	

}
