package com.github.sawied.security.rest;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtAuthenticationCookieFilter extends OncePerRequestFilter {
	
	public static final  String JWT_TOKEN_NAME="jwt-token";
	
	@Autowired
	private AgentTokenUtil jwtTokenUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authToken = extractTokenFromCookie(request);
		
	    String username = jwtTokenUtil.getUsernameFromToken(authToken);
	    Collection<? extends GrantedAuthority>  roles=jwtTokenUtil.getRolesFromToken(authToken);

	    logger.info("checking authentication for user " + username);

	    if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
	            if (jwtTokenUtil.validateToken(authToken)) {
	                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, null,roles);
	                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	                logger.info("authenticated user " + username + ", setting security context");
	                SecurityContextHolder.getContext().setAuthentication(authentication);
	            }
	        }

	    filterChain.doFilter(request, response);
		 
	}
	
	
	private String extractTokenFromCookie(HttpServletRequest request){
		Cookie[] cookies =request.getCookies();
		String token=null;
		if(cookies!=null){
			for(int i =0;i<cookies.length;i++){
				Cookie cookie=cookies[i];
				if(JWT_TOKEN_NAME.equals(cookie.getName())){
					token=cookie.getValue();
				}
			}
		}
		return token;
	}

}
