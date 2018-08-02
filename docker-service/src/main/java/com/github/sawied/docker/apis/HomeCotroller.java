package com.github.sawied.docker.apis;

import java.util.List;

import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.NameClassPairCallbackHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeCotroller {

	@Autowired
	private LdapTemplate ldapTemplate;
	
	
	@RequestMapping("/users/{ids}")
	public String appInfo(String id) throws NamingException {
		DirContextAdapter object = (DirContextAdapter) ldapTemplate.lookup("cn=InfoDir-HACN-VTA-Users,ou=application");
		NamingEnumeration<? extends Attribute> enumeration = object.getAttributes().getAll();
		while(enumeration.hasMoreElements()) {
			String eid=enumeration.next().getID();
			System.out.println("id:"+eid+",value");
		}
		return "DONE";
	}
	
	
}
