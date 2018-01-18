package com.github.sawied.microservice.authorization.userdetails;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class ExtentedUser extends User {

	private static final long serialVersionUID = 6191869519347604880L;

	private Map<String, Object> inadditionInfo = null;

	public ExtentedUser(String username, Collection<? extends GrantedAuthority> authorities,
			Map<String, Object> inadditionInfo) {
		super(username, "password", true, true, true, true, authorities);
		this.inadditionInfo = inadditionInfo;
	}

	public Map<String, Object> getInadditionInfo() {
		return inadditionInfo;
	}

	public void setInadditionInfo(Map<String, Object> inadditionInfo) {
		this.inadditionInfo = inadditionInfo;
	}

}
