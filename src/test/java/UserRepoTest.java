import static org.junit.Assert.*;

import java.nio.channels.AsynchronousServerSocketChannel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ryz.project.api.Logger;
import com.ryz.project.api.UserRepo;
import com.ryz.project.domain.User;
import com.ryz.project.implementations.LoggerImpl;


public class UserRepoTest {

	private ApplicationContext applicationContextTest;
	private UserRepo userRepoTest;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("setUp");
		applicationContextTest = new ClassPathXmlApplicationContext("SpringConfiguration.xml");
		userRepoTest = applicationContextTest.getBean("myUserRepoImpl", UserRepo.class);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown");
		userRepoTest.closeDatabaseConnection();
		((ConfigurableApplicationContext) applicationContextTest).close();
	}

	@Test
	public void testCreateUser() {
		String name = "Adam";
		String surname = "Adamczyk";
		int age = 20;
		User user = userRepoTest.createUser(name, surname, age);
		assertEquals(name, user.getName());
		assertEquals(surname, user.getSurname());
		assertEquals(age, user.getAge());
	}

	@Test
	public void testUpdateAge() {
		User user = userRepoTest.createUser("Adam", "Adamczyk", 20);
		int age = 30;
		userRepoTest.updateAge(user.getId(), 30);
		assertEquals(age, user.getAge());
	}

	@Test
	public void testFind() {
		User user = userRepoTest.createUser("Adam", "Adamczyk", 20);
		User userFound = userRepoTest.find(user.getId());
		assertEquals(userFound.getAge(), user.getAge());
		assertEquals(userFound.getName(), user.getName());
		assertEquals(userFound.getSurname(), user.getSurname());
	}

	@Test
	public void testEqualsByID() {
		User user = userRepoTest.createUser("Adam", "Adamczyk", 20);
		assertEquals(userRepoTest.equalsByID(user.getId(), user), true);
	}

}
