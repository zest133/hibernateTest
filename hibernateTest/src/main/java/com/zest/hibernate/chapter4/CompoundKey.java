package com.zest.hibernate.chapter4;

import java.io.Serializable;

import javax.persistence.Embeddable;

//필히 Serializable 해줘야함. 
@Embeddable
public class CompoundKey implements Serializable{

	private int userId;
	private int accountId;
	
	public CompoundKey(int userId, int accountId){
		this.accountId = accountId;
		this.userId = userId;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	
	
	
}
