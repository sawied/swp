package com.github.sawied.microservice.authorization.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/devices")
public class DeviceInformationController {

	@RequestMapping("/{id}")
	@ResponseBody
	public DeviceInformation obtainUserInfor(String id){
		
		DeviceInformation deviceInformation=new DeviceInformation();
		deviceInformation.setDeviceName("mvtm");
		deviceInformation.setDeviceId("mvtm"+id);
		deviceInformation.setBranch("shanghai hongkou street");
		return deviceInformation;
	}
	
	
}
