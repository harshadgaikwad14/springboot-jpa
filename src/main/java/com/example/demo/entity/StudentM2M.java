package com.example.demo.entity;
 
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
 
@Entity
@Table
@Audited
public class StudentM2M {
 
    @Id
    @GeneratedValue
    private long id;
 

    private String firstName;
 

    private String lastName;
 
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "students_subjects", 
        joinColumns = { @JoinColumn(name = "student_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "subject_id") })
    private List<SubjectM2M> subjectM2Ms = new ArrayList<SubjectM2M>();
 
    public StudentM2M() {
    }
 
    public StudentM2M(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
 
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
 
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    public String getLastName() {
        return lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
  
 
     
    public List<SubjectM2M> getSubjectM2Ms() {
		return subjectM2Ms;
	}

	public void setSubjectM2Ms(List<SubjectM2M> subjectM2Ms) {
		this.subjectM2Ms = subjectM2Ms;
	}

	
	 public void addSubjectM2M(SubjectM2M subjectM2M) {
			this.subjectM2Ms.add(subjectM2M);
			subjectM2M.getStudentM2Ms().add(this);
		}

		public void removeSubjectM2M(SubjectM2M subjectM2M) {
			this.subjectM2Ms.remove(subjectM2M);
			subjectM2M.getStudentM2Ms().remove(this);
		}
	   
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
		StudentM2M other = (StudentM2M) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StudentM2M [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	
	
 
}