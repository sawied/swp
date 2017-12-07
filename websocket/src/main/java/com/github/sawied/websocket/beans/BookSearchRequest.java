package com.github.sawied.websocket.beans;

import java.util.Date;

public class BookSearchRequest{

	private String name =null;
	
	private Boolean useDate =null;
	
	private Date date =null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getUseDate() {
		return useDate;
	}

	public void setUseDate(Boolean useDate) {
		this.useDate = useDate;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
