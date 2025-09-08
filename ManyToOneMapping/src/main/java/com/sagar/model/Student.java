package com.sagar.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {

	@Id
	@Column(name = "rollNo")
	private int rollNo;

	@Column(name = "name")
	private String name;

	@Column(name = "standard")
	private int standard;

	@ManyToOne
	@JoinColumn(name = "addridFk")
	private Address addr;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int rollNo, String name, int standard, Address addr) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.standard = standard;
		this.addr = addr;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStandard() {
		return standard;
	}

	public void setStandard(int standard) {
		this.standard = standard;
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", standard=" + standard + ", addr=" + addr + "]";
	}

}
