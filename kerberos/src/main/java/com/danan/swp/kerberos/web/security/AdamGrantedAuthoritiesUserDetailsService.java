package com.danan.swp.kerberos.web.security;

import java.rmi.RemoteException;
import java.util.HashSet;
import java.util.Set;

import javax.ejb.CreateException;
import javax.naming.NamingException;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.util.Assert;

import com.ibm.websphere.wim.SchemaConstants;
import com.ibm.websphere.wim.client.LocalServiceProvider;
import com.ibm.websphere.wim.exception.WIMException;
import com.ibm.websphere.wim.util.SDOHelper;
import commonj.sdo.DataObject;


/**
 * this class will retrieve the roles from websphere ADADM 
 * @author danan
 *
 */
public class AdamGrantedAuthoritiesUserDetailsService implements
		AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> {

	@Override
	public UserDetails loadUserDetails(PreAuthenticatedAuthenticationToken token)
			throws UsernameNotFoundException {
		Assert.notNull(token.getDetails());
		String name = token.getName();
		return createUserDatils(name);
	}
	
	protected UserDetails createUserDatils(String name) {
		Set<GrantedAuthority> set = new HashSet<GrantedAuthority>();
		set.add(new SimpleGrantedAuthority("ROLE_PSWPUser"));
		set.add(new SimpleGrantedAuthority("ROLE_authenticatedUser"));
		return new User(name, "N/A", set);
	}
	
	private Set<String> loadUserRoles(String name){
		try {
			LocalServiceProvider lsp = new LocalServiceProvider(null);
		
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (WIMException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (CreateException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 *  Gets the search results for the search base set
	 *  @param searchBase the search base to be set on search control
	 *  @throws Exception
	 */
	public  void search(String searchBase) throws Exception
	{
	    DataObject root = SDOHelper.createRootDataObject();
	    LocalServiceProvider lsp = new LocalServiceProvider(null);
	    DataObject searchCtrl = SDOHelper.createControlDataObject(root, null, SchemaConstants.DO_SEARCH_CONTROL);
	    searchCtrl.getList(SchemaConstants.PROP_PROPERTIES).add("cn");
	    searchCtrl.getList(SchemaConstants.PROP_PROPERTIES).add("sn");
	    searchCtrl.getList(SchemaConstants.PROP_PROPERTIES).add("telephoneNumber");
	    searchCtrl.getList(SchemaConstants.PROP_SEARCH_BASES).add(searchBase);
	    searchCtrl.setString(SchemaConstants.PROP_SEARCH_EXPRESSION, "@xsi:type='PersonAccount' and uid='*'");
	    
	    System.out.println("Input datagraph before searching with search base "+ searchBase +" " 
	            + root);
	    DataObject searchRoot = lsp.search(root);
	    System.out.println("Output datagraph after searching with search base "+ searchBase +" " 
	            + searchRoot);
	}

}
