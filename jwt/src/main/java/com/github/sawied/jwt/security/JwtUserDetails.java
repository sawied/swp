package com.github.sawied.jwt.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;


/**
 * custom define for user details
 * @author James X W Zhang
 *
 */
public class JwtUserDetails extends User{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1059414578849353580L;
	
	/**
	 * Client Id
	 */
	private String clientId=null;	

	/**
	 * 
	 * @param username
	 * @param password
	 * @param authorities
	 */
	public JwtUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);		
		this.clientId=username;
	}







	public String getClientId() {
		return clientId;
	}

	
	
		
	

}
