package com.ryz.project.api;

import java.util.List;

import com.ryz.project.domain.User;

public interface UserRepo {
	User createUser(String name, String surname, int age);

	void setLogger(Logger logger);

	Logger getLogger();

	void closeDatabaseConnection();

	void updateAge(int id, int age);

	User find(int id);

	boolean equalsByID(int id, User user);

	List<String> selectItems(String item);

	List<String> selectItemsHeaving(String item, String parameter, String value, char comparator);

	List<User> selectUsers();

	List<User> selectUsersHeaving(String parameter, String value, char comparator);

	<T> void showResults(List<T> list, Class<T> type);
}
