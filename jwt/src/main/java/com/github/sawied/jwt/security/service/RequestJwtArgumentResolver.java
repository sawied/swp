package com.github.sawied.jwt.security.service;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;

/**
 * extract the http header entity. 
 * @author James X W Zhang
 *
 */
public class RequestJwtArgumentResolver implements WebArgumentResolver {
	
	
	public static final String CLIENT_ID="client-id";
	 
	
	@Override
	public Object resolveArgument(MethodParameter methodParameter, NativeWebRequest webRequest) throws Exception {
		Annotation[] paramAnns = methodParameter.getParameterAnnotations();
		for(Annotation annotation :paramAnns ){
			if(JwtAuthentication.class.isInstance(annotation)){
				HttpServletRequest request = (HttpServletRequest)webRequest.getNativeRequest();
				String clientId = request.getHeader(CLIENT_ID);
				JwtAuthenticationRequest jwtRequest = new JwtAuthenticationRequest();
				jwtRequest.setClientId(clientId);
				return jwtRequest;
			}
		}
		return WebArgumentResolver.UNRESOLVED;
	}

}
