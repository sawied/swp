package com.github.sawied.jwt.security.service;


/**
 * be used to describe the token information from  client
 * main property is client id identifying which client is.
 * @author James X W Zhang
 *
 */
public class JwtAuthenticationRequest {
	
	private String clientId;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	

}
