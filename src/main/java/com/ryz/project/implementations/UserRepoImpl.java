package com.ryz.project.implementations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.ryz.project.api.Logger;
import com.ryz.project.api.UserRepo;
import com.ryz.project.domain.Phone;
import com.ryz.project.domain.Administrator;
import com.ryz.project.domain.Employee;
import com.ryz.project.domain.User;

public class UserRepoImpl implements UserRepo {
	private Logger logger;
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private FactoryQuery factoryQuery;

	public UserRepoImpl(Logger logger) {
		this.logger = logger;
		this.entityManagerFactory = Persistence.createEntityManagerFactory("myPersistence");
		this.entityManager = entityManagerFactory.createEntityManager();
		this.factoryQuery = new FactoryQuery(this.entityManager);
	}

	public List<String> selectItems(String item) {
		Map<String,String> queryHashMap = new HashMap<String,String>();
		queryHashMap.put("action", "select");
		queryHashMap.put("item", item);
		return entityManager.createQuery(factoryQuery.returnQuery(queryHashMap, String.class)).getResultList();
	}

	public List<String> selectItemsHeaving(String item, String parameter, String value, char comparator) {
		Map<String,String> queryHashMap = new HashMap<String,String>();
		queryHashMap.put("action", "select");
		queryHashMap.put("item", item);
		queryHashMap.put("comparator", Character.toString(comparator));
		queryHashMap.put("parameter", parameter);
		queryHashMap.put("value", value);
		return entityManager.createQuery(factoryQuery.returnQuery(queryHashMap, String.class)).getResultList();
	}

	public List<User> selectUsers() {
		Map<String,String> queryHashMap = new HashMap<String,String>();
		queryHashMap.put("action", "select");
		queryHashMap.put("item", "users");
		return entityManager.createQuery(factoryQuery.returnQuery(queryHashMap, User.class)).getResultList();
	}

	public List<User> selectUsersHeaving(String parameter, String value, char comparator) {
		Map<String,String> queryHashMap = new HashMap<String,String>();
		queryHashMap.put("action", "select");
		queryHashMap.put("item", "users");
		queryHashMap.put("comparator", Character.toString(comparator));
		queryHashMap.put("parameter", parameter);
		queryHashMap.put("value", value);
		return entityManager.createQuery(factoryQuery.returnQuery(queryHashMap, User.class)).getResultList();
	}
	
	public Employee createEmployee(String name, String surname, int age, List<Phone> phone, int salary)
	{
		Employee employee = new Employee(name, surname, age, phone, salary);
		entityManager.getTransaction().begin();
		phone.stream().forEach(p -> entityManager.persist(p));
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		logger.log("Create " + employee);
		return employee;
	}
	public Administrator createAdministrator(String name, String surname, int age, int accessLevel) {
		Administrator administrator = new Administrator(name, surname, age, accessLevel);
		entityManager.getTransaction().begin();
		entityManager.persist(administrator);
		entityManager.getTransaction().commit();
		logger.log("Create " + administrator);
		return administrator;
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

	public <T> void showResults(List<T> list, Class<T> type) {
		list.stream().forEach(System.out::println);
	}
}
