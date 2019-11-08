package com.example.demo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.Audited;

@Entity
@Audited
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique = true, nullable = false)
	private String name;
	private String description;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	private String subDivisionName;
	private String remark;
	private String address;
	private boolean active;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "name", column = @Column(name = "cp_name")),
			@AttributeOverride(name = "contactNo", column = @Column(name = "cp_contact_no")),
			@AttributeOverride(name = "emailId", column = @Column(name = "cp_email_id")) })
	private ContactPerson contactPerson;
	
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "name", column = @Column(name = "client_name")),
			@AttributeOverride(name = "contactNo", column = @Column(name = "client_contact_no")),
			@AttributeOverride(name = "emailId", column = @Column(name = "client_email_id")) })
	private Client client;
	
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "name", column = @Column(name = "architect_name")),
			@AttributeOverride(name = "contactNo", column = @Column(name = "architect_contact_no")),
			@AttributeOverride(name = "emailId", column = @Column(name = "architect_email_id")) })
	private Architect architect;

	
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "name", column = @Column(name = "structural_name")),
			@AttributeOverride(name = "contactNo", column = @Column(name = "structural_contact_no")),
			@AttributeOverride(name = "emailId", column = @Column(name = "structural_email_id")) })
	private Structural structural;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<User> users = new ArrayList<User>();
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Requisition> requisitions = new ArrayList<Requisition>();

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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getSubDivisionName() {
		return subDivisionName;
	}

	public void setSubDivisionName(String subDivisionName) {
		this.subDivisionName = subDivisionName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ContactPerson getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(ContactPerson contactPerson) {
		this.contactPerson = contactPerson;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public CommonAudit getCommonAudit() {
		return commonAudit;
	}

	public void setCommonAudit(CommonAudit commonAudit) {
		this.commonAudit = commonAudit;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Architect getArchitect() {
		return architect;
	}

	public void setArchitect(Architect architect) {
		this.architect = architect;
	}

	public Structural getStructural() {
		return structural;
	}

	public void setStructural(Structural structural) {
		this.structural = structural;
	}

	public List<Requisition> getRequisitions() {
		return requisitions;
	}

	public void setRequisitions(List<Requisition> requisitions) {
		this.requisitions = requisitions;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	

	
	

	
}
