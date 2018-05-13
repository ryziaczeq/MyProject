package com.ryz.project.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Phone {
	@Id
	@GeneratedValue
	private int id;

	private String number;

	public Phone(String number) {
		super();
		this.number = number;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return number;
	}

	public void setStreet(String street) {
		this.number = street;
	}
}
