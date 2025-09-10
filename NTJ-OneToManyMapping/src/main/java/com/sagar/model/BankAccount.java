package com.sagar.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "OTM_BankAccount")
public class BankAccount implements Serializable {

	@Id
	@Column(name = "lid")
	private Integer lid;

	@Column(name = "accountType")
	private String accountType;

	@Column(name = "accountNumber")
	private String accountNumber;

	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankAccount(Integer lid, String accountType, String accountNumber) {
		super();
		this.lid = lid;
		this.accountType = accountType;
		this.accountNumber = accountNumber;
	}

	public Integer getLid() {
		return lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "DrivingLicense [lid=" + lid + ", accountType=" + accountType + ", accountNumber=" + accountNumber + "]";
	}

}
