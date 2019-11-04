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
public class VendorRequisitionItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToOne
	@JoinColumn(name = "vendor_id", referencedColumnName = "id")
	private Vendor vendor;
	@OneToOne
	@JoinColumn(name = "requisition_item_id", referencedColumnName = "id")
	private RequisitionItem requisitionItem;
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
	public RequisitionItem getRequisitionItem() {
		return requisitionItem;
	}
	public void setRequisitionItem(RequisitionItem requisitionItem) {
		this.requisitionItem = requisitionItem;
	}
	@Override
	public String toString() {
		return "VendorRequisitionItem [id=" + id + ", vendor=" + vendor + ", requisitionItem=" + requisitionItem + "]";
	}
	
	
	

}
