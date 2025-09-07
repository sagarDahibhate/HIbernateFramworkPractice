package com.sagar.model;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "custTab")
public class Customer {

	@Id
	@Column(name = "cid")
	private int custId;

	@Column(name = "cname")
	private String custName;

	@ElementCollection
	@CollectionTable(name = "custData", joinColumns = @JoinColumn(name = "cid"))
	@Column(name = "data")
	private Set<String> custData = new HashSet<String>();

	@ElementCollection
	@CollectionTable(name = "mapTab", joinColumns = @JoinColumn(name = "cid"))
	@MapKeyColumn(name = "pos")
	@Column(name = "data")
	private Map<Integer, String> Data = new TreeMap<Integer, String>();

	public Customer() {
		super();
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public Set<String> getCustData() {
		return custData;
	}

	public void setCustData(Set<String> custData) {
		this.custData = custData;
	}

	public Map<Integer, String> getData() {
		return Data;
	}

	public void setData(Map<Integer, String> data) {
		Data = data;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custData=" + custData + ", Data=" + Data
				+ "]";
	}
}
