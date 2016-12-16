package com.danan.business.smot.web.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;
import org.springframework.web.util.WebUtils;

public class ServiceErrorHandlerResolver extends AbstractHandlerExceptionResolver {

    
    
	private static final String DEFAULT_ERROR_VIEW_NAME = "jacksonJsonView";
	private ExceptionErrorResolver errorResolver =null;
	
	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ServletWebRequest webRequest = new ServletWebRequest(request, response);
		ServiceError serviceError = errorResolver.resolveError(webRequest, handler, ex);
		applyResponseStatus(webRequest,serviceError);
		return new ModelAndView(DEFAULT_ERROR_VIEW_NAME).addObject(serviceError);
	}

	private void applyResponseStatus(ServletWebRequest request, ServiceError serviceError) {
		if(!WebUtils.isIncludeRequest(request.getRequest())){			
			request.getResponse().setStatus(serviceError.getStatus().value());
		}
	}

	public void setErrorResolver(ExceptionErrorResolver errorResolver) {
	    this.errorResolver = errorResolver;
	}
	
	

}
