package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.envers.Audited;

@Entity
@Audited
public class RequisitionItem implements Serializable {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "item_id", referencedColumnName = "id",nullable=false)
	private Item item;
	@ManyToOne
	@JoinColumn(name = "grade_id", referencedColumnName = "id",nullable=false)
	private Grade grade;
	@ManyToOne
	@JoinColumn(name = "unit_id", referencedColumnName = "id",nullable=false)
	private Unit unit;
	private Long quantity;
	private String usedFor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "requisition_id" ,referencedColumnName = "id")
	private Requisition requisition;
	

	@Embedded
	private CommonAudit commonAudit;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public String getUsedFor() {
		return usedFor;
	}

	public void setUsedFor(String usedFor) {
		this.usedFor = usedFor;
	}

	public CommonAudit getCommonAudit() {
		return commonAudit;
	}

	public void setCommonAudit(CommonAudit commonAudit) {
		this.commonAudit = commonAudit;
	}

	public Requisition getRequisition() {
		return requisition;
	}

	public void setRequisition(Requisition requisition) {
		this.requisition = requisition;
	}
	

	

	
	

	

	
}
