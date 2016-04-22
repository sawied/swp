package com.danan.business.smot.web;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class DummyUserDetail implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		return new User(username, "notUsed", true, true, true, true,
                AuthorityUtils.createAuthorityList("ROLE_USER"));
	}

}
