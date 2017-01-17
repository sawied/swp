package com.github.sawied.jwt.security;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.sawied.jwt.security.TDESCipherer;
import com.github.sawied.jwt.security.service.JwtAuthenticationRequest;

public class TDESSecurityKeyAuthenticationProvider implements AuthenticationProvider {
	
	private static final Logger  LOG = LoggerFactory.getLogger(TDESSecurityKeyAuthenticationProvider.class);

	@Autowired
	private TDESCipherer cipherer=null;
	
	private ObjectMapper objectMapper =new ObjectMapper();
	
	
	private AuthenticationUserDetailsService<CiphertextAuthenticationToken> userDetailService = null;

	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		CiphertextAuthenticationToken cipherAuthentication= (CiphertextAuthenticationToken)authentication;
		
		String principal=(String)cipherAuthentication.getPrincipal();
		CiphertextAuthenticationToken result =null;
		
		//get the authentication request
		JwtAuthenticationRequest request = extractJwtAuthenticationRequest(principal);
		
		if(validateJwtRequest(request)){	
			Set<GrantedAuthority> set = new HashSet<GrantedAuthority>();
			result = new CiphertextAuthenticationToken(set,request.getClientId(),"N/A");
			UserDetails ud=userDetailService.loadUserDetails(result);
			set.addAll(ud.getAuthorities());
			result.setDetails(ud);
		}
		
		return result;
	}
	
	
	/**
	 * validate authentication request,
	 * validate the client id &  duration of validity
	 * @param request
	 * @return
	 */
	private boolean validateJwtRequest(JwtAuthenticationRequest request) {
		return request.getClientId()!=null && request.getTimestamp()!= 0 && System.currentTimeMillis()-request.getTimestamp()<1000*60*60*24*100;
	}

	/**
	 * retrieve Authentication Request from encoded String
	 * @param principal
	 * @return
	 */
	private JwtAuthenticationRequest extractJwtAuthenticationRequest(String principal){
		
		JwtAuthenticationRequest request =null;
		try {
			byte[] clearText = cipherer.decrypt(principal.getBytes());
			request=objectMapper.readValue(clearText, JwtAuthenticationRequest.class);
			
		} catch (Exception e) {
			LOG.info("authenticate failed ,beacuse of can't decrypt the ciphertext");
		}
		
		return request;
	}
	

	@Override
	public boolean supports(Class<?> authentication) {
		return CiphertextAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
