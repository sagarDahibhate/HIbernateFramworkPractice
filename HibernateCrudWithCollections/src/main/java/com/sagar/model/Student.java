package com.sagar.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "StudTab")
public class Student {

	@Id
	@Column(name = "sid")
	private int stdId;

	@Column(name = "sname")
	private String stdName;

	@ElementCollection // Batata hai ki ye collection hai.
	@CollectionTable(name = "stdproj", joinColumns = @JoinColumn(name = "sid")) // Child table ka naam aur foreign key
																				// specify karta hai.
	@OrderColumn(name = "pos") // List ke liye position maintain karta hai.
	@Column(name = "Data") // Child table ke column ka naam batata hai.
	private List<String> stdData = new ArrayList<String>();

	public Student() {
		super();
	}

	public int getStdId() {
		return stdId;
	}

	public void setStdId(int stdId) {
		this.stdId = stdId;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public List<String> getStdData() {
		return stdData;
	}

	public void setStdData(List<String> stdData) {
		this.stdData = stdData;
	}

	@Override
	public String toString() {
		return "Student [stdId=" + stdId + ", stdName=" + stdName + ", stdData=" + stdData + "]";
	}

}
