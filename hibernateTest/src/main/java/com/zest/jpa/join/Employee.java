package com.zest.jpa.join;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(EmployeeId.class)
public class Employee {

	@Id
	private String branchName;
	@Id
	private int idEmployee;

	private String firstName;
	private String lastName;
	private int salary;

	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(String branchName, int idEmployee, String firstName, String lastNAme, int salary) {
		// TODO Auto-generated constructor stub
		this.branchName = branchName;
		this.idEmployee = idEmployee;
		this.firstName = firstName;
		this.lastName = lastNAme;
		this.salary = salary;
	}
	
	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public int getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}