package com.zest.jpa.manytomanyextracolumn;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceUnit;
import javax.persistence.Transient;


@Entity(name="project_groups")
//@IdClass(GroupID.class)
public class Group implements Serializable {

	
	private int idx;
	
	private String role;

	private Person person;
	private Project project;
	
	public Group() {
		// TODO Auto-generated constructor stub
	}
	
	public Group(Person person, Project project, String role) {
		this.person = person;
		this.project = project;
		this.role = role;
	}
	
	@Column(name = "role")
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

//	@Id
	@ManyToOne
	@JoinColumn(name="person_id",foreignKey=@ForeignKey(name="FK_GROUP_PERSON"))
//	@JoinColumn(name="person_id1")
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

//	@Id
	@ManyToOne
	@JoinColumn(name="project_id",foreignKey=@ForeignKey(name="FK_GROUP_PROJECT"))
//	@JoinColumn(name="project_id")
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Transient
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
}
