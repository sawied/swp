package com.danan.business.smot.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpMethod;

/**
 * Servlet Filter implementation class CORSFilter
 */
@WebFilter("/*")
public class CORSFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CORSFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		 HttpServletRequest httpRequest = (HttpServletRequest) request; 
		 HttpServletResponse httpResponse = (HttpServletResponse) response;
		 String method = httpRequest.getMethod();
		 if(HttpMethod.OPTIONS.name().equals(method)){			 
			 httpResponse.setHeader("Access-Control-Allow-Origin", "*");
			 httpResponse.setHeader("Access-Control-Allow-Methods", "POST");
			 httpResponse.setHeader("Access-Control-Allow-Headers", "X-HSBC,x-requested-with");
			 httpResponse.setHeader("Access-Control-Max-Age", "1728000");
			 httpResponse.flushBuffer();
		 }else{
			 // pass the request along the filter chain
			 chain.doFilter(request, response);			 
		 }
		 
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
