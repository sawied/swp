package com.github.sawied.jwt.security.service;

import java.io.IOException;
import java.util.Calendar;

import javax.json.Json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.sawied.jwt.security.TDESCipherer;

@RestController
@RequestMapping("auth")
public class AuthenticationRestController {

	@Autowired
	private TDESCipherer cipherer = null;

	@RequestMapping(value = "/{certification}", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@PathVariable("certification") String certification,
			Device device) throws CertificationNotPresentException {
		if (certification == null) {
			throw new CertificationNotPresentException();
		}

		try {
			JwtAuthenticationRequest request = extractJwtRequest(certification);
			
			if(validateCertification(request)){
				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	private boolean validateCertification(JwtAuthenticationRequest request) {
		Calendar calender = Calendar.getInstance();
		calender.setTimeInMillis(request.getTimestamp());
		Calendar lastday =Calendar.getInstance();
		return calender.before(lastday);
	}

	private JwtAuthenticationRequest extractJwtRequest(String certification) throws Exception {
		byte[] decryptText = cipherer.decrypt(certification.getBytes());
		String clearText = new String(decryptText);
		ObjectMapper om = new ObjectMapper();
		return om.readValue(clearText, JwtAuthenticationRequest.class);
	}

}
