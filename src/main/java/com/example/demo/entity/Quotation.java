package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.Audited;

@Entity
@Audited
public class Quotation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private boolean active;

	@Temporal(TemporalType.DATE)
	private Date deliveryDate;
	
	@Temporal(TemporalType.DATE)
	private Date lastDateOfSubmission;
	
	private String remark;
	
	@OneToOne
	@JoinColumn(name = "requisition_id")
	private Requisition requisition; 

	@Embedded
	private CommonAudit commonAudit;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public CommonAudit getCommonAudit() {
		return commonAudit;
	}

	public void setCommonAudit(CommonAudit commonAudit) {
		this.commonAudit = commonAudit;
	}

	

	public Date getLastDateOfSubmission() {
		return lastDateOfSubmission;
	}

	public void setLastDateOfSubmission(Date lastDateOfSubmission) {
		this.lastDateOfSubmission = lastDateOfSubmission;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Requisition getRequisition() {
		return requisition;
	}

	public void setRequisition(Requisition requisition) {
		this.requisition = requisition;
	}
	
	

}
