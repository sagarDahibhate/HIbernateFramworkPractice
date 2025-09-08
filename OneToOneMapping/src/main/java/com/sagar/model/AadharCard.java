package com.sagar.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "AadharCard")
public class AadharCard {

	@Id
	@Column(name = "id")
	private int aid;

	@Column(name = "aadharNumber")
	private String aadharNo;

	public AadharCard(int aid, String aadharNo) {
		super();
		this.aid = aid;
		this.aadharNo = aadharNo;
	}

	public AadharCard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	@Override
	public String toString() {
		return "AadharCard [aid=" + aid + ", aadharNo=" + aadharNo + "]";
	}

}
