package com.sagar.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "OTO_FK_Person")
public class Person implements Serializable{

	@Id
	@Column(name = "pId")
	private int pId;

	@Column(name = "name")
	private String name;	

	@Column(name = "address")
	private String address;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(int pId, String name, String address) {
		super();
		this.pId = pId;
		this.name = name;
		this.address = address;
	}

	public int getPId() {
		return pId;
	}

	public void setPId(int pId) {
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

	@Override
	public String toString() {
		return "Person [pId=" + pId + ", name=" + name + ", Address=" + address + "]";
	}

}
