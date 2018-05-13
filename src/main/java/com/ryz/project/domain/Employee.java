package com.ryz.project.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Employee extends User {

	private int salary;
	@OneToMany
	@JoinColumn(name = "user_id")
	private List<Phone> phone;

	public Employee() {
		super();
	}

	public Employee(String name, String surname, int age, List<Phone> phone, int salary) {
		super(name, surname, age);
		this.phone = phone;
		this.salary = salary;

	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public List<Phone> getPhone() {
		return phone;
	}

	public void setPhone(List<Phone> phone) {
		this.phone = phone;
	}

}
