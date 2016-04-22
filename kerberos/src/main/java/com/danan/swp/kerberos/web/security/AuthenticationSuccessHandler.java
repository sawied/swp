package com.danan.swp.kerberos.web.security;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;

public class AuthenticationSuccessHandler implements ApplicationListener<AuthenticationSuccessEvent> {
	
	private static final Log LOG = LogFactory.getLog(AuthenticationSuccessHandler.class);

	@Override
	public void onApplicationEvent(AuthenticationSuccessEvent event) {
		LOG.error("authentication success , info " + event );	
	}

}
