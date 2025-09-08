package com.sagar.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "People")
public class People {

	@Id
	@Column(name = "p_id")
	private int id;

	@Column(name = "Name")
	private String name;

	@OneToMany
	@JoinColumn(name = "Mob_idFk")
	private Set<Mobile> mobiles = new HashSet<Mobile>();

	public People() {
		super();
		// TODO Auto-generated constructor stub
	}

	public People(int id, String name, Set<Mobile> mobiles) {
		super();
		this.id = id;
		this.name = name;
		this.mobiles = mobiles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Mobile> getMobiles() {
		return mobiles;
	}

	public void setMobiles(Set<Mobile> mobiles) {
		this.mobiles = mobiles;
	}

	@Override
	public String toString() {
		return "People [id=" + id + ", name=" + name + ", mobiles=" + mobiles + "]";
	}

}
