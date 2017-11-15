package com.danan.services;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.util.StringValueResolver;

import com.github.sawied.hacn.entity.CustomerInfo;
import com.github.sawied.hacn.service.CustomerInfoResponse;

public class CustomerInforMashallTest {

	
	@Test
	public void mashallSuccessTest() {
		try {
			JAXBContext context =JAXBContext.newInstance("com.github.sawied.hacn.service");
			Marshaller createMarshaller = context.createMarshaller();
			createMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
			createMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			createMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			CustomerInfoResponse response = new CustomerInfoResponse();
			CustomerInfo ci = new CustomerInfo();
			ci.setCompanyType("chinasofti");
			response.setCustomerInfoReturn(ci);
			createMarshaller.marshal(response, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void unmashallSuccessTest(){
		InputStream resource=null;
		try {
			JAXBContext context =JAXBContext.newInstance("com.github.sawied.hacn.service");
			Unmarshaller createUnmarshaller = context.createUnmarshaller();
			resource = CustomerInforMashallTest.class.getResourceAsStream("CustomerInforResponse.xml");
			StreamSource ss =new StreamSource(resource);
			Assert.assertNotNull(resource);
			Object object = createUnmarshaller.unmarshal(ss);
			Assert.assertNotNull(object);
		} catch (JAXBException e) {
			e.printStackTrace();
		}finally {
			try {
				resource.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
