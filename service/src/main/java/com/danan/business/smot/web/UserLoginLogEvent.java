package com.danan.business.smot.web;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import com.danan.business.smot.domain.LoginLog;
import com.danan.business.smot.repositories.LoginLogRepository;



public class UserLoginLogEvent implements
		ApplicationListener<ApplicationEvent>, ApplicationContextAware {

	private ApplicationContext applicationContext = null;

	
	public void onApplicationEvent(ApplicationEvent appEvent) {
		if (appEvent instanceof AuthenticationSuccessEvent) {
			AuthenticationSuccessEvent event = (AuthenticationSuccessEvent) appEvent;
			UserDetails userDetails = (UserDetails) event.getAuthentication()
					.getPrincipal();
			WebAuthenticationDetails webAuthDetails = (WebAuthenticationDetails) event
					.getAuthentication().getDetails();
			String remoteHost = webAuthDetails.getRemoteAddress();
			String name = userDetails.getUsername();
			LoginLogRepository loginLogRepository = (LoginLogRepository) applicationContext
					.getBean("loginLogRepository");
			loginLogRepository.saveLoginLog(new LoginLog(name, remoteHost));
		}

	}


	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

}
