package com.zest.jpa.manytomanyextracolumn;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="person")
public class Person {

	private int idx;

	private String name;
	private String email;
	private String password;
	
	private List<Group> groups;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	public Person(String name, String email, String password) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Person(String name, String email, String password, List<Group> groups) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.email = email;
		this.password = password;
		this.groups = groups;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "name=" + name + ", password=" + password + ", email=" + email;
	}

	
}
