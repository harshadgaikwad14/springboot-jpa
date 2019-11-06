package com.example.demo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.Audited;

@Entity
@Audited
public class Quotation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "quotation")
	private List<VendorRequisition> vendorRequisitions;

	private boolean notifyToVendor;
	private boolean replyFromVendor;
	private boolean active;

	@Temporal(TemporalType.DATE)
	private Date lastDateOfSubmission;

	@Embedded
	private CommonAudit commonAudit;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isNotifyToVendor() {
		return notifyToVendor;
	}

	public void setNotifyToVendor(boolean notifyToVendor) {
		this.notifyToVendor = notifyToVendor;
	}

	public boolean isReplyFromVendor() {
		return replyFromVendor;
	}

	public void setReplyFromVendor(boolean replyFromVendor) {
		this.replyFromVendor = replyFromVendor;
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

	public List<VendorRequisition> getVendorRequisitions() {
		return vendorRequisitions;
	}

	public void setVendorRequisitions(List<VendorRequisition> vendorRequisitions) {
		this.vendorRequisitions = vendorRequisitions;
	}

	public Date getLastDateOfSubmission() {
		return lastDateOfSubmission;
	}

	public void setLastDateOfSubmission(Date lastDateOfSubmission) {
		this.lastDateOfSubmission = lastDateOfSubmission;
	}

}
