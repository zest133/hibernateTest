package com.zest.hibernate.chapter3;

import javax.persistence.Embeddable;

@Embeddable
public class SchoolDetail {

	private String schoolAddress;
	private boolean isPublishSchool;
	private int studentCount;
	
	public String getSchoolAddress() {
		return schoolAddress;
	}
	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
	}
	public boolean isPublishSchool() {
		return isPublishSchool;
	}
	public void setPublishSchool(boolean isPublishSchool) {
		this.isPublishSchool = isPublishSchool;
	}
	public int getStudentCount() {
		return studentCount;
	}
	public void setStudentCount(int studentCount) {
		this.studentCount = studentCount;
	}
	
	
}
