package com.example.demo.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.envers.Audited;

@Entity
@Audited
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique = true, nullable = false)
	private String name;
	private String description;

	@ManyToMany(mappedBy = "roles")
	private Collection<User> users;

	@ManyToMany
	@JoinTable(name = "roles_priviliges", joinColumns = @JoinColumn(referencedColumnName = "id", name = "role_id"), inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id"))
	private Collection<Privilege> priviliges;

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

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}

	public Collection<Privilege> getPriviliges() {
		return priviliges;
	}

	public void setPriviliges(Collection<Privilege> priviliges) {
		this.priviliges = priviliges;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", description=" + description + ", priviliges=" + priviliges
				+ "]";
	}

	
	
	

}
