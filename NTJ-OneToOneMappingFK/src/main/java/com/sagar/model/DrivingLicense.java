package com.sagar.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "OTO_FK_DrivingLicense")
public class DrivingLicense implements Serializable {

	@Id
	@Column(name = "lid")
	private Integer lid;

	@Column(name = "licenseType")
	private String licenseType;

	@Column(name = "issuedBy")
	private String issuedBy;

	@JoinColumn(name = "person_Id_Fk",unique = true)
	@ManyToOne
	private Person person;

	public DrivingLicense() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DrivingLicense(Integer lid, String licenseType, String issuedBy, Person person) {
		super();
		this.lid = lid;
		this.licenseType = licenseType;
		this.issuedBy = issuedBy;
		this.person = person;
	}

	public Integer getLid() {
		return lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

	public String getLicenseType() {
		return licenseType;
	}

	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}

	public String getIssuedBy() {
		return issuedBy;
	}

	public void setIssuedBy(String issuedBy) {
		this.issuedBy = issuedBy;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "DrivingLicense [lid=" + lid + ", licenseType=" + licenseType + ", issuedBy=" + issuedBy + ", person="
				+ person + "]";
	}

}
