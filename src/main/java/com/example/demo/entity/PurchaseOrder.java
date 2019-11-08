package com.example.demo.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.envers.Audited;

@Entity
@Audited
public class PurchaseOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String remark;
	
	@OneToOne
	@JoinColumn(name = "quotation_id",referencedColumnName = "id")
	private Quotation quotation;
	
	/*
	 * @OneToMany private List<VendorRequisitionItem> vendorRequisitionItem;
	 */
	
	@Embedded
	private CommonAudit commonAudit;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public CommonAudit getCommonAudit() {
		return commonAudit;
	}

	public void setCommonAudit(CommonAudit commonAudit) {
		this.commonAudit = commonAudit;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the quotation
	 */
	public Quotation getQuotation() {
		return quotation;
	}

	/**
	 * @param quotation the quotation to set
	 */
	public void setQuotation(Quotation quotation) {
		this.quotation = quotation;
	}



}
