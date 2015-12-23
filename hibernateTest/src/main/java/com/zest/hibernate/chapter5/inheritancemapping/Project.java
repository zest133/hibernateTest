package com.zest.hibernate.chapter5.inheritancemapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
//single table 실행시 stategy가 없는것과 동일한 결과를 볼수있다. 
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)

//각 class마다 table이 생성되며, 하위 class들은 pk키를 기준으로 테이블이 생성된다. 
//또, 최상위 클래스는 pk와 하위 컬럼만 존재한다. 
@Inheritance(strategy=InheritanceType.JOINED)

//class에 맞는 컬럼 값만 저장하며, pk는 최상위 클래스 값으로 중복되지 않은 값으로 저장된다. 
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Project {

	@Id
	@GeneratedValue
	private int projectId;
	private String projectName;
	
	
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	
}
