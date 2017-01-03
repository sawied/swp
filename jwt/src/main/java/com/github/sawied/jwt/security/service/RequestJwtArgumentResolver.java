package com.github.sawied.jwt.security.service;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;

public class RequestJwtArgumentResolver implements WebArgumentResolver {

	 
	
	@Override
	public Object resolveArgument(MethodParameter methodParameter, NativeWebRequest webRequest) throws Exception {
		Annotation[] paramAnns = methodParameter.getParameterAnnotations();
		Class<?> parameterType = methodParameter.getParameterType();
		for(Annotation annotation :paramAnns ){
			if(JwtAuthentication.class.isInstance(annotation)){
				JwtAuthentication jwtAnnotation=(JwtAuthentication)annotation;
				String key = jwtAnnotation.value();	
				HttpServletRequest request = (HttpServletRequest)webRequest.getNativeRequest();
				String header = request.getHeader(key);
				
			}
		}
		return WebArgumentResolver.UNRESOLVED;
	}

}
