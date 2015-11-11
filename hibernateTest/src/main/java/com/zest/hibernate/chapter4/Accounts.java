package com.zest.hibernate.chapter4;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Accounts {

	//compound key로 옮겼으니 주석으로 막는다. 
//	private int userId;
//	private int accountId;
	
	
	@Id
	//만약 변수에 annotaion을 할꺼면 private는 안된다. 다른 객체이므로. getxxx 에 annotaion을 붙이면 된다. 
	CompoundKey compoundKey;
	private int accountBalance;
	
	
	public CompoundKey getCompoundKey() {
		return compoundKey;
	}
	public void setCompoundKey(CompoundKey compoundKey) {
		this.compoundKey = compoundKey;
	}
	public int getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	
}
