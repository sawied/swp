package com.github.sawied.persistent.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity(name="auditLogDetail")
public class AuditLogDetail {
    
   
    	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id = null;
	
	@Column(name="action",length=80)
	private String action=null;
	
	@Column(name="description",length=300)
	private String description=null;
	
	
	
	public AuditLogDetail() {
	    super();
	}

	public AuditLogDetail(String action, String description) {
	    super();
	    this.action = action;
	    this.description = description;
	}

	@ManyToOne(optional=false)
	@JoinColumn(name="auditLogId")
	private UserAuditLog auditLog=null; 
	
	public Long getId() {
	    return id;
	}

	public void setId(Long id) {
	    this.id = id;
	}

	public String getAction() {
	    return action;
	}

	public void setAction(String action) {
	    this.action = action;
	}

	public String getDescription() {
	    return description;
	}

	public void setDescription(String description) {
	    this.description = description;
	}
	
	
	
	public UserAuditLog getAuditLog() {
	    return auditLog;
	}

	public void setAuditLog(UserAuditLog auditLog) {
	    this.auditLog = auditLog;
	}

	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ((id == null) ? 0 : id.hashCode());
	    return result;
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
		return true;
	    if (obj == null)
		return false;
	    if (getClass() != obj.getClass())
		return false;
	    AuditLogDetail other = (AuditLogDetail) obj;
	    if (id == null) {
		if (other.id != null)
		    return false;
	    } else if (!id.equals(other.id))
		return false;
	    return true;
	}
	

}
