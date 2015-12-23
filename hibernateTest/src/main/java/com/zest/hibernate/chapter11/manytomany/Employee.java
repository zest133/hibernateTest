package com.zest.hibernate.chapter11.manytomany;

import java.io.Serializable;
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
@Table(name="EMPLOYEE")
public class Employee implements Serializable {
	private static final long serialVersionUID = -8821659676348395539L;
	private String employeeId;
	private String employeeName;
	private String employeeType;
	private List<ProjectEmployee> projects;
	
	@Id
	@Column(name="EMPLOYEE_ID")
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
	@Basic
	@Column(name="EMPLOYEE_NAME")
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	@Basic
	@Column(name="EMPLOYEE_TYPE")
	public String getEmployeeType() {
		return employeeType;
	}
	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}
	public List<ProjectEmployee> getProjects() {
		return projects;
	}
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="employee")
	public void setProjects(List<ProjectEmployee> projects) {
		this.projects = projects;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
