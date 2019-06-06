package com.github.sawied.docker.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

@Configuration
public class ServiceConfig {
	
	@Bean
	public LdapContextSource ldapContextSource(@Value("${ldap.url}") String ldapUrl,@Value("${ldap.base}") String base,@Value("${ldap.user}")String userDn,@Value("${ldap.password}")String password) {
		LdapContextSource ldapContextSource = new LdapContextSource();
		ldapContextSource.setUrl(ldapUrl);
		ldapContextSource.setBase(base);
		ldapContextSource.setUserDn(userDn);
		ldapContextSource.setPassword(password);
		return ldapContextSource;
	}
	
	@Bean
	public LdapTemplate ldapTemplate(LdapContextSource ldapContextSource) {
		return new LdapTemplate(ldapContextSource);
	}
}
