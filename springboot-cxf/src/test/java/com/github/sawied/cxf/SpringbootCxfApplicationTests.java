package com.github.sawied.cxf;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.junit.Assert;
import org.junit.Test;


public class SpringbootCxfApplicationTests {

	@Test
	public void webserviceClientSuccess() throws MalformedURLException {
		String address = "http://localhost:8080/Service/Greeter";
		Service service = Service.create(new URL(address+"?wsdl"), new QName("http://sawied.github.com/cxf","Greeter"));
		Greeter greeter = service.getPort(new QName("http://sawied.github.com/cxf", "SoapPort"), Greeter.class);
		String result = greeter.sayHi("danan");
		System.out.println(result);
		Assert.assertEquals("cxf web service: danan", result);
	}

}
