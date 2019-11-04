package com.example.demo.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.hibernate.envers.Audited;

@Entity
@Audited
public class Unit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique = true, nullable = false)
	private String name;
	private String description;

	@ManyToMany(mappedBy = "units", fetch = FetchType.LAZY)
	private Collection<Grade> grades;

	@OneToOne(mappedBy = "unit")
	private RequisitionItem requisitionItem;

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

	public CommonAudit getCommonAudit() {
		return commonAudit;
	}

	public void setCommonAudit(CommonAudit commonAudit) {
		this.commonAudit = commonAudit;
	}

	public Collection<Grade> getGrades() {
		return grades;
	}

	public void setGrades(Collection<Grade> grades) {
		this.grades = grades;
	}

	public RequisitionItem getRequisitionItem() {
		return requisitionItem;
	}

	public void setRequisitionItem(RequisitionItem requisitionItem) {
		this.requisitionItem = requisitionItem;
	}

	@Override
	public String toString() {
		return "Unit [id=" + id + ", name=" + name + ", description=" + description + ", commonAudit=" + commonAudit
				+ "]";
	}

}
