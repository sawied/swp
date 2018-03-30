package com.github.sawied.jweb.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.Type;

@Entity(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id = null;
	
	@Column
	private String name=null;
	
	@Column(columnDefinition="XMLType",name="xml_data")
	@Type(type = "com.github.sawied.jweb.entity.HibernateXMLType")
	private byte[] xmlData=null;
	

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

	public byte[] getXmlData() {
		return xmlData;
	}

	public void setXmlData(byte[] xmlData) {
		this.xmlData = xmlData;
	}
	
}
