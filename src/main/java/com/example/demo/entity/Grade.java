package com.example.demo.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
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

import org.hibernate.envers.Audited;

import com.example.demo.repository.CommonAudit;

@Entity
@Audited
public class Grade {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique = true, nullable = false)
	private String name;
	private String description;
	
	@ManyToMany(mappedBy = "grades")
	private Collection<Item> items;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "grades_units", joinColumns = @JoinColumn(referencedColumnName = "id", name = "grade_id"), inverseJoinColumns = @JoinColumn(name = "unit_id", referencedColumnName = "id"))
	private Collection<Unit> units;
	
	

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

	public Collection<Item> getItems() {
		return items;
	}

	public void setItems(Collection<Item> items) {
		this.items = items;
	}

	public Collection<Unit> getUnits() {
		return units;
	}

	public void setUnits(Collection<Unit> units) {
		this.units = units;
	}

	@Override
	public String toString() {
		return "Grade [id=" + id + ", name=" + name + ", description=" + description + ", commonAudit=" + commonAudit
				+ "]";
	}

	/*
	 * @Override public String toString() { return "Grade [id=" + id + ", name=" +
	 * name + ", description=" + description + ", units=" + units + ", commonAudit="
	 * + commonAudit + "]"; }
	 */
	
	
	

}
