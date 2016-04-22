package com.danan.business.smot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class DefaultAppController {
	
	
	@RequestMapping("/default")
	public String defaultHome(){
		return "default";
	}
	
	@RequestMapping(value="/*",method=RequestMethod.OPTIONS)
	public void crossDomainHeader(){
		
	}
}
