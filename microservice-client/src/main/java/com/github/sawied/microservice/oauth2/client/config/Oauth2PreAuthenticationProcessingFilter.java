package com.github.sawied.microservice.oauth2.client.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.BearerTokenExtractor;
import org.springframework.security.oauth2.provider.authentication.TokenExtractor;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

/**
 * 
 * @author James X W Zhang
 *
 */
public class Oauth2PreAuthenticationProcessingFilter extends AbstractPreAuthenticatedProcessingFilter {

	private TokenExtractor tokenExtractor=new BearerTokenExtractor();
	
	
	@Override
	protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
		Authentication authentication = tokenExtractor.extract(request);
		if(authentication!=null) {
			return authentication.getPrincipal();
		}
		return null;
	}

	@Override
	protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
		return "N/A";
	}

}
