package com.github.sawied.agent.config;

import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Order(0)
public class AgentWebApplicationInitializer extends
	AbstractAnnotationConfigDispatcherServletInitializer {

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
	return new String[]{"/"};
    }
    
    

}
