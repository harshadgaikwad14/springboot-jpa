package com.example.demo.entity;
 
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
 
@Entity
@Table
@Audited
public class SubjectM2M {
 
    @Id
    @GeneratedValue
    private long id;
 
   
    @Column(nullable = false,unique = true)
    private String name;
     
     
    @ManyToMany(mappedBy="subjectM2Ms",fetch = FetchType.EAGER)
    private List<StudentM2M> studentM2Ms = new ArrayList<StudentM2M>();
     
    public SubjectM2M(){
         
    }
     
    public SubjectM2M(String name){
        this.name = name;
    }
 
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public void addStudentM2M(StudentM2M studentM2M) {
		this.studentM2Ms.add(studentM2M);
		studentM2M.getSubjectM2Ms().add(this);
	}

	public void removeStudentM2M(StudentM2M studentM2M) {
		this.studentM2Ms.remove(studentM2M);
		studentM2M.getSubjectM2Ms().remove(this);
	}
   
	
 
    @Override
	public String toString() {
		return "SubjectM2M [id=" + id + ", name=" + name + "]";
	}

	public List<StudentM2M> getStudentM2Ms() {
		return studentM2Ms;
	}

	public void setStudentM2Ms(List<StudentM2M> studentM2Ms) {
		this.studentM2Ms = studentM2Ms;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubjectM2M other = (SubjectM2M) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
 
}