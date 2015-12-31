package com.zest.jpa.manytomanyextracolumn;

import java.io.Serializable;

public class GroupID implements Serializable {

	private int person;
	private int project;

	public GroupID() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean equals(Object obj) {
		if (this.toString().equals(obj.toString())) {
			return true;
		}

		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	public int getPerson() {
		return person;
	}

	public void setPerson(int person) {
		this.person = person;
	}

	public int getProject() {
		return project;
	}

	public void setProject(int project) {
		this.project = project;
	}

	

}
