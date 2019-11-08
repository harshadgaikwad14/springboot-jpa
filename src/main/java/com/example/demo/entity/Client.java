package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Client implements Serializable {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String contactNo;
	private String emailId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	

	
	
	



}
