package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.envers.Audited;

@Entity
@Audited
public class VendorRequisition {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToOne
	@JoinColumn(name = "vendor_id", referencedColumnName = "id")
	private Vendor vendor;
	@OneToOne
	@JoinColumn(name = "requisition_id", referencedColumnName = "id")
	private Requisition requisition;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Vendor getVendor() {
		return vendor;
	}
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	public Requisition getRequisition() {
		return requisition;
	}
	public void setRequisition(Requisition requisition) {
		this.requisition = requisition;
	}
	@Override
	public String toString() {
		return "VendorRequisition [id=" + id + ", vendor=" + vendor + ", requisition=" + requisition + "]";
	}
	
	

}
