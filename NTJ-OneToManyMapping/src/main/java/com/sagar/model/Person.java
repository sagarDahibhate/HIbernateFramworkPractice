package com.sagar.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "OTM_Person")
public class Person implements Serializable {

	@Id
	@Column(name = "pId")
	private int pId;

	@Column(name = "name")
	private String name;

	@Column(name = "address")
	private String address;

	@OneToMany
	@JoinColumn(name = "bankAcc_fk")
	private Set<BankAccount> bankAcc=new HashSet<BankAccount>();

	public Person(int pId, String name, String address, Set<BankAccount> bankAcc) {
		super();
		this.pId = pId;
		this.name = name;
		this.address = address;
		this.bankAcc = bankAcc;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<BankAccount> getBankAcc() {
		return bankAcc;
	}

	public void setBankAcc(Set<BankAccount> bankAcc) {
		this.bankAcc = bankAcc;
	}

	@Override
	public String toString() {
		return "Person [pId=" + pId + ", name=" + name + ", address=" + address + ", bankAcc=" + bankAcc + "]";
	}

}
