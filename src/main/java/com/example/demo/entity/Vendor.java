package com.example.demo.entity;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.envers.Audited;

@Entity
@Audited
public class Vendor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique = true, nullable = false)
	private String name;
	private String description;
	private String gstNo;
	private String address;
	@ManyToOne
	@JoinColumn(name = "vendor_type_id" ,referencedColumnName = "id",nullable=false)
	private VendorType vendorType;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "name", column = @Column(name = "bank_name")),
			@AttributeOverride(name = "branchName", column = @Column(name = "bank_branch_name")),
			@AttributeOverride(name = "accountNo", column = @Column(name = "bank_account_no")),
			@AttributeOverride(name = "ifscCode", column = @Column(name = "bank_ifsc_code")),
			@AttributeOverride(name = "micrCode", column = @Column(name = "bank_micr_code")) })

	private Bank bank;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "name", column = @Column(name = "cp_name")),
			@AttributeOverride(name = "contactNo", column = @Column(name = "cp_contact_no")),
			@AttributeOverride(name = "emailId", column = @Column(name = "cp_email_id")) })
	private ContactPerson contactPerson;
	
	

	@Embedded
	private CommonAudit commonAudit;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	

	public VendorType getVendorType() {
		return vendorType;
	}

	public void setVendorType(VendorType vendorType) {
		this.vendorType = vendorType;
	}

	

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public ContactPerson getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(ContactPerson contactPerson) {
		this.contactPerson = contactPerson;
	}

	public CommonAudit getCommonAudit() {
		return commonAudit;
	}

	public void setCommonAudit(CommonAudit commonAudit) {
		this.commonAudit = commonAudit;
	}

	

	@Override
	public String toString() {
		return "Vendor [id=" + id + ", name=" + name + ", description=" + description + ", gstNo=" + gstNo
				+ ", address=" + address + ", vendorType=" + vendorType + ", bank=" + bank + ", contactPerson="
				+ contactPerson + ", commonAudit=" + commonAudit + "]";
	}
	
	

}
