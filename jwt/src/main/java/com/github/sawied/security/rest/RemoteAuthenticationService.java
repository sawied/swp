package com.github.sawied.security.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * All the responsibility of this Class is to retrieve 
 * @author James X W Zhang
 *
 */
public class RemoteAuthenticationService extends AbstractUserDetailsAuthenticationProvider{

	private static final Logger LOG =LoggerFactory.getLogger(RemoteAuthenticationService.class);
	
	private RestTemplate restTemplate = new RestTemplate();
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		LOG.info("No thing need to do for additional Authentication check");
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		Map<String,String> variables=new HashMap<String,String>();
		variables.put("username", username);
		variables.put("password", authentication.getPrincipal().toString());
		
		String result=restTemplate.getForObject("http://localhost/dummy/UserDetails.json", String.class, variables);
		
		AgentUserInformation agentInfo;
		UserDetails userDetails =null;
		try {
			agentInfo = objectMapper.readValue(result, AgentUserInformation.class);
			Collection<? extends GrantedAuthority> authorities =buildAuthoritiesFromList(agentInfo.getAuthorities());
			userDetails=new AgentUserDetails(username, agentInfo.getAgentCode(), authorities);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userDetails ;
	}

	
	
	private Collection<? extends GrantedAuthority> buildAuthoritiesFromList(List<String> roles){
		List<GrantedAuthority> granted = new ArrayList<GrantedAuthority>();
		if(roles!=null){
			for(String role:roles){
				granted.add(new SimpleGrantedAuthority(role));
			}
		}
		
		return granted;
	}
	
	
}
