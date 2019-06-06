package com.github.sawied.cxf.service;

import javax.jws.WebService;

import com.github.sawied.cxf.Greeter;

@WebService(serviceName = "Greeter", portName = "SoapPort",
targetNamespace = "http://sawied.github.com/cxf",
endpointInterface = "com.github.sawied.cxf.Greeter")
public class GreeterService implements Greeter {



	@Override
	public String sayHi(String request) {
		
		return "cxf web service: " + request;
	}

}
