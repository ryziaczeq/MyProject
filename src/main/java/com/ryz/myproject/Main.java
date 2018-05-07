package com.ryz.myproject;

public class Main {

	public static void main(String[] args) {
		ManageEmployeeDatabase manageEmployeeDatabase = new ManageEmployeeDatabase();
		Employee employee = new Employee("Adam", "Adamczyk", 20);
		manageEmployeeDatabase.add(employee);
		Employee employee1 = manageEmployeeDatabase.find(1);
		if (employee1 != null)
			System.out.println(employee1.getId());
		System.out.println(manageEmployeeDatabase.equalsByID(1, employee));
		manageEmployeeDatabase.closeDatabaseConnection();
	}

}
