package com.example.demo.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.envers.Audited;

@Entity
@Audited
public class VendorRequisitionItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Long vendorId;

	private Long requisitionItemId;

	private BigDecimal amount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

	public Long getRequisitionItemId() {
		return requisitionItemId;
	}

	public void setRequisitionItemId(Long requisitionItemId) {
		this.requisitionItemId = requisitionItemId;
	}

}
