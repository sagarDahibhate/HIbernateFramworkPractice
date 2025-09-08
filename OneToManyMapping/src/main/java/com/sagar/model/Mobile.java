package com.sagar.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Mobile")
public class Mobile {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "company_Name")
	private String company;

	public Mobile(int id, String company) {
		super();
		this.id = id;
		this.company = company;
	}

	public Mobile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Mobile [id=" + id + ", company=" + company + "]";
	}

}
