package com.sagar.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "OTO_PK_LibraryManage")
public class LibraryManage {
	
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "membership")
	private String LibraryManage;

	@OneToOne
	private Student student;

	public LibraryManage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LibraryManage(Integer id, String LibraryManage, Student student) {
		super();
		this.id = id;
		this.LibraryManage = LibraryManage;
		this.student = student;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibraryManage() {
		return LibraryManage;
	}

	public void setLicenseType(String LibraryManage) {
		this.LibraryManage = LibraryManage;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "DrivingLicense [id=" + id + ", LibraryManage=" + LibraryManage + ", student=" + student + "]";
	}
	
	
}
