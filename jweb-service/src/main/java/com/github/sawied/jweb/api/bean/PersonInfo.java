package com.github.sawied.jweb.api.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class PersonInfo {

	@NotNull
	@Length(max=50,min=1)
	private String name;
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	
	
	
	
}
