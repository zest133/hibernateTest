package com.zest.hibernate.chapter7.onetomanymapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private int studentId;
	private String studentName;
	
	@ManyToOne
	@JoinColumn(name="college_id")
	private College college1;
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public College getCollege() {
		return college1;
	}
	public void setCollege(College college1) {
		this.college1 = college1;
	}
	
	
}
