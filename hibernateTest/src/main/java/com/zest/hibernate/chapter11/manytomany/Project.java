package com.zest.hibernate.chapter11.manytomany;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PROJECT")
public class Project implements Serializable {
	private static final long serialVersionUID = 2703915705484865029L;
	private String projectId;
	private String projectTitle;
	private String projectDuration;
	private List<ProjectEmployee> employees;

	// getters and setters
	
	
	
	public void addEmployee(Employee employee, Date dateAdded) {
		ProjectEmployee association = new ProjectEmployee();
		association.setEmployee(employee);
		association.setProject(this);
		association.setEmployeeId(employee.getEmployeeId());
		association.setProjectId(this.getProjectId());
		association.setDateAdded(dateAdded);
		this.employees.add(association);
		employee.getProjects().add(association);
	}

	@Id
	@Column(name="PROJECT_ID")
	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	@Basic
	@Column(name="PROJECT_TITLE")
	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	
	@Basic
	@Column(name="PROJECT_DURATION")
	public String getProjectDuration() {
		return projectDuration;
	}

	public void setProjectDuration(String projectDuration) {
		this.projectDuration = projectDuration;
	}

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="project")
	public List<ProjectEmployee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<ProjectEmployee> employees) {
		this.employees = employees;
	}
}
