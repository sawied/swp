package com.github.sawied.persistent.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class UserAuditLog {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id = null;

	private Short code = null;

	private String message = null;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "starttimestamp")
	private Date start = null;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "endtimestamp")
	private Date end = null;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="auditLog",cascade=CascadeType.PERSIST)
	@Fetch(FetchMode.SUBSELECT)
	private Collection<AuditLogDetail> logDetails =new ArrayList<AuditLogDetail>();
	
	@ManyToOne(targetEntity=User.class)
	@JoinColumn(name="userId",nullable=true)
	private User user=null;

	@Transient
	private Double duration;

	public UserAuditLog() {
		super();
	}
	

	public UserAuditLog(Long id, String message, Double duration) {
		super();
		this.id = id;
		this.message = message;
		this.duration = duration;
	}


	public Collection<AuditLogDetail> getLogDetails() {
	    return logDetails;
	}


	public void setLogDetails(Collection<AuditLogDetail> logDetails) {
	    this.logDetails = logDetails;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Short getCode() {
		return code;
	}

	public void setCode(Short code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}


	public User getUser() {
	    return user;
	}


	public void setUser(User user) {
	    this.user = user;
	}
	
	

}
