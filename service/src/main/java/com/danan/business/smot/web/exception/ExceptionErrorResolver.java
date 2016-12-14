package com.danan.business.smot.web.exception;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * the factory method for Exception Mapping,
 *  convert and return ServiceError 
 * @author James X W Zhang
 *
 */
public interface ExceptionErrorResolver {

	/**
	 * according to input Exception,generate related Service Error for Client side representation 
	 * @param request
	 * @param handler
	 * @param ex
	 * @return
	 */
	 ServiceError resolveError(ServletWebRequest request, Object handler, Exception ex);
}
