package com.danan.swp.kerberos.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibm.websphere.wim.SchemaConstants;
import com.ibm.websphere.wim.client.LocalServiceProvider;
import com.ibm.websphere.wim.ras.WIMTraceHelper;
import com.ibm.websphere.wim.util.SDOHelper;

import commonj.sdo.DataObject;


@Controller
public class KerberosProxyCaller {

	
	
	@RequestMapping("/")
	@ResponseBody
	public String printConfigrations(){
		try {
			getGroupMembership("cn=wasadmin,cn=Users,dc=danan,dc=local");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "all are working !";
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
	
	/**
	 *  getGroupMembership gets the nested groups
	 *  @param memberDn uniqueName of the group
	 */
	public static void getGroupMembership(String memberDn)
	{
	    try
	    {
	        DataObject root = SDOHelper.createRootDataObject();
	        LocalServiceProvider service = new LocalServiceProvider(null);
	        DataObject entity = SDOHelper.createEntityDataObject(root, null, SchemaConstants.DO_PERSON_ACCOUNT);
	        // Set the uniqueName of the group
	        entity.createDataObject(SchemaConstants.DO_IDENTIFIER).setString(SchemaConstants.PROP_UNIQUE_NAME, 
	                memberDn);
	        // Set the Group membership control
	        DataObject grpMbrshipCtrl = SDOHelper.createControlDataObject(root, null, 
	                SchemaConstants.DO_GROUP_MEMBERSHIP_CONTROL);
	        // Set the property of level to retrieve all the nested entities
	        grpMbrshipCtrl.setInt(SchemaConstants.PROP_LEVEL, SchemaConstants.PROP_LEVEL_NESTED);
	        // Retrieve cn attribute for all groups
	        grpMbrshipCtrl.getList(SchemaConstants.PROP_PROPERTIES).add("cn");
	        System.out.println("Input data graph before getting group membership of user"+ printDO(root));
	        // Get the members of the group
	        root = service.get(root);
	        System.out.println("Output data graph after getting group membership of user"+ printDO(root));
	    }
	    catch(Exception e)
	    {
	        e.printStackTrace();
	    }
	}
	
	
	
    public static String printDO(DataObject obj)
    {
        return WIMTraceHelper.printDataObject(obj);
    }
	
}
