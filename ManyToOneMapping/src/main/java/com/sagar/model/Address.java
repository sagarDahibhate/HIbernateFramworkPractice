package com.sagar.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@Column(name = "aid")
	private int addrId;

	@Column(name = "loc")
	private String loc;

	@Column(name = "pin")
	private String pin;

	public Address() {
		super();
	}

	public int getAddrId() {
		return addrId;
	}

	public void setAddrId(int addrId) {
		this.addrId = addrId;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "Address [addrId=" + addrId + ", loc=" + loc + ", pin=" + pin + "]";
	}

}
