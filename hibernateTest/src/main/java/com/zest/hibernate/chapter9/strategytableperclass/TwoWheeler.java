package com.zest.hibernate.chapter9.strategytableperclass;

import javax.persistence.Entity;

@Entity
public class TwoWheeler extends Vehicle{

	private String SteeringHandle;

	public String getSteeringHandle() {
		return SteeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		SteeringHandle = steeringHandle;
	}
	
	
}
