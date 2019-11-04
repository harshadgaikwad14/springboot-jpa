package com.example.demo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.Audited;

@Entity
@Audited
public class Requisition {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique = true, nullable = false)
	private String name;
	private String description;
	@Temporal(TemporalType.DATE)
	private Date expectedDeliveryAt;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "requisition")
	private List<RequisitionItem> requisitionItems;

	@ManyToOne
	@JoinColumn(name = "project_id", referencedColumnName = "id")
	private Project project;

	private String remark;

	@OneToOne(mappedBy = "requisition")
	private VendorRequisition vendorRequisition;

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

	public Date getExpectedDeliveryAt() {
		return expectedDeliveryAt;
	}

	public void setExpectedDeliveryAt(Date expectedDeliveryAt) {
		this.expectedDeliveryAt = expectedDeliveryAt;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<RequisitionItem> getRequisitionItems() {
		return requisitionItems;
	}

	public void setRequisitionItems(List<RequisitionItem> requisitionItems) {
		this.requisitionItems = requisitionItems;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return "Requisition [id=" + id + ", name=" + name + ", description=" + description + ", expectedDeliveryAt="
				+ expectedDeliveryAt + ", remark=" + remark + "]";
	}

	public VendorRequisition getVendorRequisition() {
		return vendorRequisition;
	}

	public void setVendorRequisition(VendorRequisition vendorRequisition) {
		this.vendorRequisition = vendorRequisition;
	}
	
	

}
