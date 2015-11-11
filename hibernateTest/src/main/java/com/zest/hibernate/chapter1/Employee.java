package com.zest.hibernate.chapter1;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "EmployeeInfo")
public class Employee {

	@Id
	@Column(name = "EmployeeId", nullable = false)
	/**
	 * sequence table을 생성.
	 * name= sequence table의 alias 이름.
	 * table은 sequence table의 이름.  
	 * pkColumnName 은  sequence table의 column이름.
	 * pkColumnValue은  sequence table 값을 저장하는 이름.. 
	 * 
	 */
	
	@TableGenerator(name = "empid", table = "emppktb", pkColumnName = "empkey"
	, pkColumnValue = "empvalue", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "empid")
//	@GeneratedValue
	private int empId;
	private String empName;

	// db에 등록은 안되고 객체에서 db와 별도의 기능이 필요할 경우 사용되는 어노테이션.
	@Transient
	private String empPassword;
	@Column(nullable = false)
	private String empEmailAddress;

	@Basic
	private boolean isPermanent;

	@Temporal(TemporalType.DATE)
	private Calendar empJoinDate;

	// @Basic
	@Temporal(TemporalType.TIMESTAMP)
	private Date empLoginTime;

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	public String getEmpEmailAddress() {
		return empEmailAddress;
	}

	public void setEmpEmailAddress(String empEmailAddress) {
		this.empEmailAddress = empEmailAddress;
	}

	//
	public boolean isPermanent() {
		return isPermanent;
	}

	public void setPermanent(boolean isPermanent) {
		this.isPermanent = isPermanent;
	}

	public Calendar getEmpJoinDate() {
		return empJoinDate;
	}

	public void setEmpJoinDate(Calendar empJoinDate) {
		this.empJoinDate = empJoinDate;
	}

	public Date getEmpLoginTime() {
		return empLoginTime;
	}

	public void setEmpLoginTime(Date empLoginTime) {
		this.empLoginTime = empLoginTime;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

}
