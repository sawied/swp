package com.danan.services;

import static org.junit.Assert.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;



public class MarshallTesting {
	
	
	private com.danan.services.noXmlElement.Customer customerWithoutXmlElement =null;
	private com.danan.services.withXmlElement.Customer customerWithXmlElement = null;

	@Before
	public void setUp() throws Exception {
		 customerWithoutXmlElement = new com.danan.services.noXmlElement.Customer();
		 customerWithXmlElement = new com.danan.services.withXmlElement.Customer();
		init(customerWithoutXmlElement,false);
		init(customerWithXmlElement,true);
	}
	
	
	private void init(Object obj,Boolean jaxb){
		BeanWrapper bw= new BeanWrapperImpl(obj);
		bw.setAutoGrowNestedPaths(true);
		bw.setPropertyValue("name", "danan");
		com.danan.services.noXmlElement.Opportunity opportunity = new com.danan.services.noXmlElement.Opportunity();
		//opportunity.setSalesOpportunityNumberC("GMT+0");
		
		
		JAXBElement<String> opportunitySalesOpportunityNumberC = new com.danan.services.withXmlElement.ObjectFactory().createOpportunitySalesOpportunityNumberC("GMT+0");
		com.danan.services.withXmlElement.Opportunity wo = new com.danan.services.withXmlElement.Opportunity();
		wo.setSalesOpportunityNumberC(opportunitySalesOpportunityNumberC);
		
		bw.setPropertyValue("plainType", jaxb?wo:opportunity);
	}

	@Test
	public void test() {
		try {
			JAXBContext context =JAXBContext.newInstance("com.danan.services.withXmlElement");
			Marshaller createMarshaller = context.createMarshaller();
			createMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
			createMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			createMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			//createMarshaller.marshal(new JAXBElement<com.danan.services.noXmlElement.Customer>( new QName("customer"),com.danan.services.noXmlElement.Customer.class,customerWithoutXmlElement), System.out);
			createMarshaller.marshal(new JAXBElement<com.danan.services.withXmlElement.Customer>( new QName("customer"),com.danan.services.withXmlElement.Customer.class,customerWithXmlElement), System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
