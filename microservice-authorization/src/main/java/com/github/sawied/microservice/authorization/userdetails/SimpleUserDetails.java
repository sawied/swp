package com.github.sawied.microservice.authorization.userdetails;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class SimpleUserDetails implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("author", "danan");
		return new ExtentedUser(username,AuthorityUtils.createAuthorityList("ROLE_USER"),map);
	}

}
