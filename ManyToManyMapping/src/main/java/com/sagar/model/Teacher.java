package com.sagar.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Teacher")
public class Teacher {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@ManyToMany
	@JoinTable(name = "teacher_collage", joinColumns = @JoinColumn(name = "tidfk"), inverseJoinColumns = @JoinColumn(name = "cidFk"))
	private Set<Collage> collages = new HashSet<>();

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teacher(int id, String name, Set<Collage> collages) {
		super();
		this.id = id;
		this.name = name;
		this.collages = collages;
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

	public Set<Collage> getCollages() {
		return collages;
	}

	public void setCollages(Set<Collage> collages) {
		this.collages = collages;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", collages=" + collages + "]";
	}

}
