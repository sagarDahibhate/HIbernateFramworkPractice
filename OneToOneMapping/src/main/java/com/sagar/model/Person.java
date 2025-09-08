package com.sagar.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Person")
public class Person {

	@Id
	@Column(name = "personId")
	private int pId;

	@Column(name = "name")
	private String name;

	@Column(name = "phoneNumber")
	private String phNo;

	@ManyToOne
	@JoinColumn(name = "adharFk", unique = true)
	private AadharCard aadharCard;

	public Person(int pId, String name, String phNo, AadharCard aadharCard) {
		super();
		this.pId = pId;
		this.name = name;
		this.phNo = phNo;
		this.aadharCard = aadharCard;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhNo() {
		return phNo;
	}

	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}

	public AadharCard getAadharCard() {
		return aadharCard;
	}

	public void setAadharCard(AadharCard aadharCard) {
		this.aadharCard = aadharCard;
	}

	@Override
	public String toString() {
		return "Person [pId=" + pId + ", name=" + name + ", phNo=" + phNo + ", aadharCard=" + aadharCard + "]";
	}

}
