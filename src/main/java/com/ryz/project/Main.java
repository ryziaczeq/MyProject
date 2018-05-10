package com.ryz.project;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ryz.project.api.UserRepo;
import com.ryz.project.domain.User;

public class Main {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("SpringConfiguration.xml");
		UserRepo userRepo = applicationContext.getBean("myUserRepoImpl", UserRepo.class);
		User user = userRepo.createUser("Adam", "Adamczyk", 20);

		User user1 = userRepo.find(user.getId());
		if (user1 != null)
			System.out.println(user1);
		System.out.println(userRepo.equalsByID(user1.getId(), user1));
		userRepo.closeDatabaseConnection();
		((ConfigurableApplicationContext) applicationContext).close();

	}

}
