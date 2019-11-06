package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.Audited;

@Entity
@Audited
public class VendorRequisition {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Long vendorId;

	private Long requisitionId;
	
	private boolean notifyToVendor;
	@Temporal(TemporalType.TIMESTAMP)
	private Date notifyToVendorAt;

	private boolean replyFromVendor;
	@Temporal(TemporalType.TIMESTAMP)
	private Date replyFromVendorAt;
	
	private String vendorRemark;
	
	@Embedded
	private CommonAudit commonAudit;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

	public Long getRequisitionId() {
		return requisitionId;
	}

	public void setRequisitionId(Long requisitionId) {
		this.requisitionId = requisitionId;
	}

	public boolean isNotifyToVendor() {
		return notifyToVendor;
	}

	public void setNotifyToVendor(boolean notifyToVendor) {
		this.notifyToVendor = notifyToVendor;
	}

	public Date getNotifyToVendorAt() {
		return notifyToVendorAt;
	}

	public void setNotifyToVendorAt(Date notifyToVendorAt) {
		this.notifyToVendorAt = notifyToVendorAt;
	}

	public boolean isReplyFromVendor() {
		return replyFromVendor;
	}

	public void setReplyFromVendor(boolean replyFromVendor) {
		this.replyFromVendor = replyFromVendor;
	}

	public Date getReplyFromVendorAt() {
		return replyFromVendorAt;
	}

	public void setReplyFromVendorAt(Date replyFromVendorAt) {
		this.replyFromVendorAt = replyFromVendorAt;
	}

	public CommonAudit getCommonAudit() {
		return commonAudit;
	}

	public void setCommonAudit(CommonAudit commonAudit) {
		this.commonAudit = commonAudit;
	}

	public String getVendorRemark() {
		return vendorRemark;
	}

	public void setVendorRemark(String vendorRemark) {
		this.vendorRemark = vendorRemark;
	}


	

}
