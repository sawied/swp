package com.github.sawied.jwt.security.service;


import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationRestController {

	@RequestMapping(value = "${jwt.route.authentication.path}", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@JwtAuthentication JwtAuthenticationRequest jwtRequest, @RequestBody JwtAuthenticationRequest authenticationRequest, Device device){
		return null;
	}
	
}
