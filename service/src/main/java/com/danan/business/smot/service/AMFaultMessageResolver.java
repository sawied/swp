package com.danan.business.smot.service;

import java.util.Iterator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.sax.SAXSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.danan.appmanagment.FaultMsg;
import org.danan.bean.commonsegment.FaultInfo;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.FaultMessageResolver;
import org.springframework.ws.soap.SoapBody;
import org.springframework.ws.soap.SoapFault;
import org.springframework.ws.soap.SoapFaultDetail;
import org.springframework.ws.soap.SoapFaultDetailElement;
import org.springframework.ws.soap.SoapMessage;

public class AMFaultMessageResolver implements FaultMessageResolver {
	
	private static Log LOG =LogFactory.getLog(AMFaultMessageResolver.class);

	JAXBContext jaxbContext ;
	
	
	
	
	public AMFaultMessageResolver() {
		try {
			jaxbContext=JAXBContext.newInstance("org.danan.appmanagment");
		} catch (JAXBException e) {
			LOG.error("jaxb init failed");
		}
	}


	@Override
	@SuppressWarnings("unchecked")
	public void resolveFault(WebServiceMessage message){
		FaultInfo fi=null;
		try {
		SoapMessage sm =(SoapMessage)message;
		SoapBody soapBody = sm.getSoapBody();
		SoapFault fault = soapBody.getFault();
		SoapFaultDetail faultDetail = fault.getFaultDetail();
		Iterator<SoapFaultDetailElement> detailEntries = faultDetail.getDetailEntries();
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		while(detailEntries.hasNext()){
			SoapFaultDetailElement next = detailEntries.next();
			SAXSource source = (SAXSource)next.getSource();
			JAXBElement<FaultInfo> unmarshal = (JAXBElement<FaultInfo>)unmarshaller.unmarshal(source);
			fi = unmarshal.getValue();
		}
		} catch (JAXBException e) {
			LOG.warn("paser the Fault Message failed.");
		}
		throw new RuntimeException(new FaultMsg("web service fault", fi)); 
		
	}
	
	

}
