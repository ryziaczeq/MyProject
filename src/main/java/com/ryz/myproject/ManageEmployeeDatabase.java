package com.ryz.myproject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class ManageEmployeeDatabase implements IManageEmployeeDatabase {
	
	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	public ManageEmployeeDatabase() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("myPersistence");
		this.entityManager = entityManagerFactory.createEntityManager();
	}
	public void closeDatabaseConnection() {
		entityManager.close();
		entityManagerFactory.close();
	}
	public void add(Employee employee){
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
	}
	public void updateAge(int id, int age) {
		Employee employee = entityManager.find(Employee.class, id);
		if (employee != null){
			entityManager.getTransaction().begin();
			employee.setAge(age);
			entityManager.getTransaction().commit();
		}
		else {
			System.out.println("Employee id: "+ id +" not found");
		}
	}
	public Employee find(int id){
		return entityManager.find(Employee.class, id);
	}
	public boolean equalsByID(int id,Employee employee) {
		return employee.equals(entityManager.find(Employee.class,id));
	}

}
