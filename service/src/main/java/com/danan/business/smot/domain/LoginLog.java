package com.danan.business.smot.domain;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.danan.business.smot.repositories.LoginLogRepository;

@Document(collection = "loginLog")
public class LoginLog {

	private String id = null;

	private String loginName = null;

	private Date loginTime = null;

	private String ipAddress = null;
	
	private Integer indexNo = null;
	
	
	public LoginLog() {
		super();
	}


	public LoginLog(String loginName, String ipAddress) {
		super();
		this.loginName = loginName;
		this.ipAddress = ipAddress;
		this.loginTime=new Date();
		this.indexNo=LoginLogRepository.MAX-1;
	}


	public String getId() {
		return id;
	}
	

	public void setId(String id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Integer getIndexNo() {
		return indexNo;
	}

	public void setIndexNo(Integer indexNo) {
		this.indexNo = indexNo;
	}
	
	

}
