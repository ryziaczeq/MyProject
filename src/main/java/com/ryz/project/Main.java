package com.ryz.project;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ryz.project.api.UserRepo;
import com.ryz.project.domain.Phone;
import com.ryz.project.domain.Administrator;
import com.ryz.project.domain.Employee;
import com.ryz.project.domain.User;

public class Main {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("SpringConfiguration.xml");
		UserRepo userRepo = applicationContext.getBean("myUserRepoImpl", UserRepo.class);

		List<Phone> phoneList = new LinkedList<Phone>();
		phoneList.add(new Phone("1888-888-888"));
		phoneList.add(new Phone("1999-999-999"));
		
		Administrator user = userRepo.createAdministrator("Adam", "Janik", 22, 1);
		Employee employee = userRepo.createEmployee("1Adam", "1Janik", 22, phoneList, 1200);
		
		//userRepo.showResults(userRepo.selectUsers(), User.class);
		//userRepo.showResults(userRepo.selectUsersHeaving("age", "21", '>'), User.class);
		//userRepo.showResults(userRepo.selectItems("surname"), String.class);
		//userRepo.showResults(userRepo.selectItemsHeaving("surname", "age", "21", '<'), String.class);

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
