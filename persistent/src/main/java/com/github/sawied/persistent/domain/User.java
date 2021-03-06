package com.github.sawied.persistent.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Cascade;


@Entity(name="Users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id =null;

	@Column
	private String name=null;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="User_Address")
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private List<Address> address =new ArrayList<Address>();
	
	@OneToMany(cascade=CascadeType.PERSIST,mappedBy="user")
	private List<UserAuditLog> logs=new ArrayList<UserAuditLog>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public List<UserAuditLog> getLogs() {
	    return logs;
	}

	public void setLogs(List<UserAuditLog> logs) {
	    this.logs = logs;
	}
	
	
}
