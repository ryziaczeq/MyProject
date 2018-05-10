package com.ryz.project.implementations;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ryz.project.api.Logger;
import com.ryz.project.api.UserRepo;
import com.ryz.project.domain.User;

public class UserRepoImpl implements UserRepo {

	private Logger logger;
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	public UserRepoImpl(Logger logger) {
		this.logger = logger;
		this.entityManagerFactory = Persistence.createEntityManagerFactory("myPersistence");
		this.entityManager = entityManagerFactory.createEntityManager();
	}

	public User createUser(String name, String surname, int age) {
		User user = new User(name, surname, age);
		this.add(user);
		logger.log("Create " + user);
		return user;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;

	}

	public void closeDatabaseConnection() {
		entityManager.close();
		entityManagerFactory.close();
	}

	public void add(User user) {
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
	}

	public void updateAge(int id, int age) {
		User employee = entityManager.find(User.class, id);
		if (employee != null) {
			entityManager.getTransaction().begin();
			employee.setAge(age);
			entityManager.getTransaction().commit();
		} else {
			System.out.println("Employee id: " + id + " not found");
		}
	}

	public User find(int id) {
		return entityManager.find(User.class, id);
	}

	public boolean equalsByID(int id, User employee) {
		return employee.equals(entityManager.find(User.class, id));
	}

}
