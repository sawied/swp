package com.github.sawied.agent.ws;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;

import com.github.sawied.services.appmanagment.AppMgmt;
import com.github.sawied.services.appmanagment.FaultMsg;
import com.github.sawied.services.appmanagment.RetrvApplicationInfoRequest;
import com.github.sawied.services.appmanagment.RetrvApplicationInfoResponse;

@Endpoint
public class AppManagerEndpoint implements AppMgmt{

    private static final String NAMESPACE_URI="http://www.github.com/sawied/services/appResourceService";

    @Override
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "RetrvApplicationInfoRequest") 
    public RetrvApplicationInfoResponse retrvApplicationInfo(
	    RetrvApplicationInfoRequest parameters) throws FaultMsg {
	
	return new RetrvApplicationInfoResponse();
    }
    
    
    
    
}
