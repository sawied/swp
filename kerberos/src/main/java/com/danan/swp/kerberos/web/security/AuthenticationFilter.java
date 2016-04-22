package com.danan.swp.kerberos.web.security;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.filter.GenericFilterBean;

/**
 * custome Filter for spnego logon
 * @author danan
 *
 */
public class AuthenticationFilter extends GenericFilterBean{
	
	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest=(HttpServletRequest) request;
		Principal userPrincipal = httpRequest.getUserPrincipal();
		if(userPrincipal!=null){
			logger.debug("the user of "+userPrincipal.getName()+" Logon ");
			
		}
		
	}

}
