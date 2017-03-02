package com.github.sawied.security.rest;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;


/**
 * Agent Details
 * @author James X W Zhang
 *
 */
public class AgentUserDetails extends User{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5822785773066374330L;
	
	private String agentCode = null;


	public AgentUserDetails(String username, String agentCode, Collection<? extends GrantedAuthority> authorities) {
		super(username, "N/A", authorities);
		this.agentCode = agentCode;
	}

	public String getAgentCode() {
		return agentCode;
	}

	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}
	
	


}
