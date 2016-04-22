package com.danan.business.smot.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity(name="Account")
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(initialValue=1,name="defaultGenerator")
    private Long id = null;
    private String userName = null;
    private String trueName = null;

    public Account() {
    }

    public Account(Long id, String userName, String trueName) {
        this.id = id;
        this.userName = userName;
        this.trueName = trueName;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }
}
