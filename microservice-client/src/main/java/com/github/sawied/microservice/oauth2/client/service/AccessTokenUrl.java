package com.github.sawied.microservice.oauth2.client.service;


public class AccessTokenUrl {
	

	private String accessTokenUri;

	
	private String userAuthorizationUri;

	public String getAccessTokenUri() {
		return accessTokenUri;
	}

	public void setAccessTokenUri(String accessTokenUri) {
		this.accessTokenUri = accessTokenUri;
	}

	public String getUserAuthorizationUri() {
		return userAuthorizationUri;
	}

	public void setUserAuthorizationUri(String userAuthorizationUri) {
		this.userAuthorizationUri = userAuthorizationUri;
	}
	
	
	

}
