package com.danan.swp.kerberos.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class KerberosProxyCaller {

	
	
	@RequestMapping("/")
	@ResponseBody
	public String printConfigrations(){
		return "all are working !";
	}
	
}
