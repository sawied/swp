package com.danan.business.smot.service;

import java.net.URL;

import javax.activation.DataHandler;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.MTOM;
import javax.xml.ws.soap.SOAPBinding;

import org.danan.appmanagment.AppMgmt;
import org.danan.appmanagment.FaultMsg;
import org.danan.appmanagment.RetrvApplicationInfoRequest;
import org.danan.appmanagment.RetrvApplicationInfoResponse;
import org.danan.bean.commonsegment.Customer;
import org.danan.bean.commonsegment.FaultInfo;

@WebService(targetNamespace = "http://www.danan.org/appManagment/", endpointInterface = "org.danan.appmanagment.AppMgmt", serviceName = "AppMgmtService", portName = "appMgmtPort", wsdlLocation = "WEB-INF/wsdl/appManagment.wsdl")
@BindingType(value = SOAPBinding.SOAP12HTTP_MTOM_BINDING)
@MTOM
public class AppMgmtService implements AppMgmt {

	@Override
	public RetrvApplicationInfoResponse retrvApplicationInfo(
			RetrvApplicationInfoRequest parameters)throws FaultMsg {

		RetrvApplicationInfoResponse retrvApplicationInfoResponse = new RetrvApplicationInfoResponse();
		
		try{
			Thread.sleep(500000);
			Customer customer = new Customer();
			URL resource = AppMgmtService.class.getClassLoader().getResource(
					"spring-mvc-pic-9.gif");
			DataHandler dh = new DataHandler(resource);
			customer.setAttachment(dh);
			customer.setName("danan");
			retrvApplicationInfoResponse.setInfo(customer);
			throw new UnsupportedOperationException("not implemented");
			
		}catch(Exception exception){
			FaultInfo faultInfo = new FaultInfo();
			faultInfo.setErrorCode("499");
			faultInfo.setReason("the App Id can't be empty");
			throw new FaultMsg("one error occur when download File.", faultInfo);
		}
	}

}
