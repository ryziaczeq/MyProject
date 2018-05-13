package com.ryz.project.implementations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		logger.log("Create " + user);
		return user;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;

	}

	public Logger getLogger() {
		return this.logger;

	}

	public void closeDatabaseConnection() {
		entityManager.close();
		entityManagerFactory.close();
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

	public List<String> selectItems(String item) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<String> query = builder.createQuery(String.class);
		Root<User> root = query.from(User.class);
		query.select(root.get(item));
		return entityManager.createQuery(query).getResultList();
	}

	private <Q, R> void compare(CriteriaQuery<Q> query, CriteriaBuilder builder, Root<R> root, String parameter,
			String value, char comparator, Class<Q> typeQuery, Class<R> typeRoot) {
		if (comparator == '>')
			query.where(builder.greaterThan(root.get(parameter), value));
		else if (comparator == '<')
			query.where(builder.lessThan(root.get(parameter), value));
		else
			query.where(builder.equal(root.get(parameter), value));
	}

	public List<String> selectItemsHeaving(String item, String parameter, String value, char comparator) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<String> query = builder.createQuery(String.class);
		Root<User> root = query.from(User.class);
		query.select(root.get(item));
		compare(query, builder, root, parameter, value, comparator, String.class, User.class);
		return entityManager.createQuery(query).getResultList();
	}

	public List<User> selectUsers() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);
		Root<User> root = query.from(User.class);
		query.select(root);
		return entityManager.createQuery(query).getResultList();
	}

	public List<User> selectUsersHeaving(String parameter, String value, char comparator) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);
		Root<User> root = query.from(User.class);
		query.select(root);
		compare(query, builder, root, parameter, value, comparator, User.class, User.class);
		return entityManager.createQuery(query).getResultList();
	}

	public <T> void showResults(List<T> list, Class<T> type) {
		list.forEach(text -> System.out.println(text));
	}
}
