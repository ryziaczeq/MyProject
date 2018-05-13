package com.ryz.project.domain;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USERR")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class User {
	@Id
	@GeneratedValue//(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int id;
	@Column(name = "NAME", nullable = false, length = 30)
	private String name;
	@Column(name = "SURNAME", nullable = false, length = 30)
	private String surname;
	@Column(name = "AGE", nullable = false)
	private int age;

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + ", age=" + age + "]";
	}
	public User() {}
	
	public User(String name, String surname, int age) {
		this.setName(name);
		this.setSurname(surname);
		this.setAge(age);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, surname, age);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null || obj.getClass() != this.getClass())
			return false;
		User employee = (User) obj;
		return (age == employee.getAge() && surname == employee.getSurname() && name == employee.getName()
				&& id == employee.getId());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
