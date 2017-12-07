package com.github.sawied.agent.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.ws.transport.http.support.AbstractAnnotationConfigMessageDispatcherServletInitializer;

@Order(0)
public class AgentWebApplicationInitializer extends
	AbstractAnnotationConfigMessageDispatcherServletInitializer{

    @Override
    protected Class<?>[] getRootConfigClasses() {
	return new Class[]{AgentRootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
	return new Class[]{AgentServletConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
	return new String[]{"/*"};
    }

    @Override
    public void onStartup(ServletContext servletContext)
	    throws ServletException {
	super.onStartup(servletContext);
	servletContext.addServlet("ws", new org.springframework.ws.transport.http.MessageDispatcherServlet());
	ServletRegistration sr=servletContext.getServletRegistration("ws");
	sr.setInitParameter("transformWsdlLocations", "true");
	sr.addMapping("/ws");
    }
    
    
    
    
    
    

    
    

}
