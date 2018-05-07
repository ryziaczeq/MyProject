package com.ryz.myproject;

public interface IManageEmployeeDatabase {
	void closeDatabaseConnection();
	void add(Employee employee);
	void updateAge(int id, int age);
	public Employee find(int id);
	boolean equalsByID(int id,Employee employee);
}
