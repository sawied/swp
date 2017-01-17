package com.github.sawied.jwt.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.sawied.jwt.security.CiphertextAuthenticationToken;
import com.github.sawied.jwt.security.JwtTokenUtil;
import com.github.sawied.jwt.security.TDESCipherer;

@RestController
@RequestMapping("auth")
public class AuthenticationRestController {
	
	@Autowired
	private TDESCipherer cipherer;
	
	@Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
   private final ObjectMapper om = new ObjectMapper();
    
    
	

	@RequestMapping(value = "/{certification}", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@PathVariable("certification") String certification,
			Device device) throws CertificationNotPresentException {
		if (certification == null) {
			throw new CertificationNotPresentException();
		}

		try {
			
			
			CiphertextAuthenticationToken ciphertext = new CiphertextAuthenticationToken(certification, null);
			
			Authentication authentication = authenticationManager.authenticate(ciphertext);
			
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			AbstractAuthenticationToken authenticationToken = (AbstractAuthenticationToken)authentication;
			
			UserDetails userDetails =(UserDetails)authenticationToken.getDetails();
			
			final String token = jwtTokenUtil.generateToken(userDetails, device);
			
			 return ResponseEntity.ok(new JwtAuthenticationResponse(token));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}


}
