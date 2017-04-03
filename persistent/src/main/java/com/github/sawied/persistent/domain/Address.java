package com.github.sawied.persistent.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id =null;

	@Column
	private String address=null;
	
	
	
	public Address() {
		super();
	}

	public Address(Long id) {
		super();
		this.id = id;
	}

	@ManyToMany(targetEntity=User.class,mappedBy="address")
	private List<User> users=new ArrayList<User>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<User> getUsers() {
		return users;
	}
	
	
	
	
	
}
