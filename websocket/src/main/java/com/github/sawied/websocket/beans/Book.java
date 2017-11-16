package com.github.sawied.websocket.beans;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Book implements Serializable {


	private static final long serialVersionUID = -4347480533291789985L;

	private Integer id =null;
	
	@NotNull
	@Size(max=20)
	private String title =null;
	
	@NotNull
	private String author =null;
	
	private Date publish=null;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getPublish() {
		return publish;
	}

	public void setPublish(Date publish) {
		this.publish = publish;
	}
	
}
