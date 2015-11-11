package com.zest.hibernate.chapter6.onetoonemapping;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


/**
 * 
 * one to one
 * ex) person data table
 * person id : 1
 *person name: aaaa
 *pdetail_fk :32768 이넘 
 *
 *person_detail
 *detailId_pk : 32768 이넘
 *income:123456786
 *job : adklja
 *zipcode : 20815
 *
 *위에 '이넘' 두개가 1:1로 맵핑. 
 */
@Entity
public class Person {

	@Id
	@GeneratedValue
	private int personId;
	private String personName;
	
	/**
	 * CascadeType의 종류에는 다음과 같은 것들이 있다.

CascadeType.RESIST – 엔티티를 생성하고, 연관 엔티티를 추가하였을 때 persist() 를 수행하면 연관 엔티티도 함께 persist()가 수행된다.  만약 연관 엔티티가 DB에 등록된 키값을 가지고 있다면 detached entity passed to persist Exception이 발생한다.
CascadeType.MERGE – 트랜잭션이 종료되고 detach 상태에서 연관 엔티티를 추가하거나 변경된 이후에 부모 엔티티가 merge()를 수행하게 되면 변경사항이 적용된다.(연관 엔티티의 추가 및 수정 모두 반영됨)
CascadeType.REMOVE – 삭제 시 연관된 엔티티도 같이 삭제됨
CascadeType.DETACH – 부모 엔티티가 detach()를 수행하게 되면, 연관된 엔티티도 detach() 상태가 되어 변경사항이 반영되지 않는다.
CascadeType.ALL – 모든 Cascade 적용


fetch 의 순위 두 개 있다

fetch=FetchType.EAGER: 실행 문 바로 꺼냈다

fetch=FetchType.LAZY: 쓸 때 비로소 꺼냈다
	 */
	@OneToOne(cascade=CascadeType.ALL, fetch= FetchType.EAGER)
	@JoinColumn(name="pDetail_FK")
	private PersonDetail pDetail;
	
	
	
	public PersonDetail getpDetail() {
		return pDetail;
	}
	public void setpDetail(PersonDetail pDetail) {
		this.pDetail = pDetail;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	
}
