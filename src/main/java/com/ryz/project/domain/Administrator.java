package com.ryz.project.domain;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Administrator extends User {

	private int accessLevel;

	
	public Administrator() {
		super();
	}

	public Administrator(String name, String surname, int age, int accessLevel) {
		super(name, surname, age);
		this.accessLevel = accessLevel;
	}

	public int getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(int accessLevel) {
		this.accessLevel = accessLevel;
	}

}
