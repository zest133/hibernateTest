package com.zest.hibernate.chapter11.manytomany;

import java.io.Serializable;

public class ProjectEmployeeId implements Serializable {
	private static final long serialVersionUID = 3284051729103828873L;
	private String employeeId;
	private String projectId;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public int hashCode() {
		return (int) (employeeId.hashCode() + projectId.hashCode());
	}

	public boolean equals(Object object) {
		if (object instanceof ProjectEmployeeId) {
			ProjectEmployeeId otherId = (ProjectEmployeeId) object;
			return (otherId.getEmployeeId() == this.getEmployeeId())
					&& (otherId.getProjectId() == this.getProjectId());
		}
		return false;
	}
}
