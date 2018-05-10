package com.ryz.project.api;

import com.ryz.project.domain.User;

public interface UserRepo {
	User createUser(String name, String surname, int age);

	void setLogger(Logger logger);

	void closeDatabaseConnection();

	void add(User user);

	void updateAge(int id, int age);

	public User find(int id);

	boolean equalsByID(int id, User user);
}
