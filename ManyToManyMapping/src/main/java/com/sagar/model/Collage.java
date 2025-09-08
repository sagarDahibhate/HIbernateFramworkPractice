package com.sagar.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Collage")
public class Collage {

	@Id
	@Column(name = "id")
	private int clgId;

	@Column(name = "Name")
	private String collageName;

	public Collage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Collage(int clgId, String collageName) {
		super();
		this.clgId = clgId;
		this.collageName = collageName;
	}

	public int getClgId() {
		return clgId;
	}

	public void setClgId(int clgId) {
		this.clgId = clgId;
	}

	public String getCollageName() {
		return collageName;
	}

	public void setCollageName(String collageName) {
		this.collageName = collageName;
	}

	@Override
	public String toString() {
		return "Collage [clgId=" + clgId + ", collageName=" + collageName + "]";
	}

}
