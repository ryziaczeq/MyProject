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

		userRepo.showResults(userRepo.selectUsers(), User.class);
		userRepo.showResults(userRepo.selectUsersHeaving("age", "21", '>'), User.class);
		userRepo.showResults(userRepo.selectItems("surname"), String.class);
		userRepo.showResults(userRepo.selectItemsHeaving("surname", "age", "21", '<'), String.class);

		userRepo.closeDatabaseConnection();
		((ConfigurableApplicationContext) applicationContext).close();

	}
}

// List<String> lista = new ArrayList<String>();
// Integer arg = 2;
// final Function<Integer, Integer> addOne = x -> x + 1;
// final Function<Integer, Integer> timeTwo = x -> x * 2;
//
// String x = addOne.andThen(timeTwo).apply(arg);
// System.out.println(x);
