package com.github.sawied.microservice.authorization.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


@Configuration
public class OauthSecurityAuthorizationConfig extends AbstractAnnotationConfigDispatcherServletInitializer implements WebApplicationInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{OauthApplicaionRootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{OauthServletConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/*"};
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
		DelegatingFilterProxy filter = new DelegatingFilterProxy("springSecurityFilterChain");
		filter.setContextAttribute("org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcher");
		servletContext.addFilter("springSecurityFilterChain", filter).addMappingForUrlPatterns(null, false, "/*");
	}
	
	

}
