package com.github.sawied.jwt.security.service;


/**
 * be used to describe the token information from  client
 * main property is client id identifying which client is.
 * @author James X W Zhang
 *
 */
public class JwtAuthenticationRequest {
	
	private String clientId;
	
	private long timestamp;
	
	private String version;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	
	
	

}
