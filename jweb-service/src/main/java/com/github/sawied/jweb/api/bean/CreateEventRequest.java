package com.github.sawied.jweb.api.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateEventRequest {

	@NotNull
	@Size(min=1,max=160)
	private String text=null;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
	
	
}
