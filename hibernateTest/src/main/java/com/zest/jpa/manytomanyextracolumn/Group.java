package com.zest.jpa.manytomanyextracolumn;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity(name="project_groups")
public class Group implements Serializable {

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

	@Id
	@ManyToOne
	@JoinColumn(name="person_id")
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Id
	@ManyToOne
	@JoinColumn(name="project_id")
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
}
