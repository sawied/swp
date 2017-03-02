package com.github.sawied.security.rest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AgentAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	
	private static final Logger LOG =LoggerFactory.getLogger(AgentAuthenticationSuccessHandler.class);
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private AgentTokenUtil agentTokenUtil;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-cache");
		Device device = DeviceUtils.getCurrentDevice(request);
		response.addCookie(buildCookieFromAuthentication(device,authentication));
		String responseStr=objectMapper.writeValueAsString(authentication.getPrincipal());
		LOG.info("authenticate success,responsed information :" );
		LOG.info(responseStr);
		response.getWriter().write(responseStr);
	}
	
	
	/**
	 * 
	 * @param authentication
	 * @return
	 */
	private Cookie buildCookieFromAuthentication(Device device,Authentication authentication){
		String token =agentTokenUtil.generateToken((UserDetails) authentication.getPrincipal(), device);
		LOG.info("authenticate success, generated token is " + token);
		Cookie cookie = new Cookie(JwtAuthenticationCookieFilter.JWT_TOKEN_NAME, token);
		cookie.setMaxAge(24*3600);
		return cookie;
	}

}
