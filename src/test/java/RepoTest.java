import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.ryz.project.api.UserRepo;
import com.ryz.project.domain.Employee;
import com.ryz.project.domain.Phone;
import com.ryz.project.implementations.LoggerImpl;
import com.ryz.project.implementations.UserRepoImpl;


@RunWith(MockitoJUnitRunner.class)
public class RepoTest {
	private UserRepo userRepo;
	@Mock
	private Employee employee;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		//userRepo = Mockito.mock(UserRepo.class);
		//Mockito.when(userRepo.createEmployee("Adam", "Adam", 20, new ArrayList<Phone>(), 1200)).
		//thenReturn(new Employee("Adam1", "Adam2", 20, new ArrayList<Phone>(), 1200));

		Mockito.when(employee.getAge()).thenReturn(20);
		//Mockito.when(employee.getAge()).thenReturn(20);
		//userRepo = new UserRepoImpl(LoggerImpl.class);

	}

	@After
	public void tearDown() throws Exception {
	}

//	@Test
//	public void testUserRepoImpl() {
//		//fail("Not yet implemented");
//	}

	@Test
	public void testCreateEmployee() {
		System.out.println(employee.getAge());
		//System.out.println(userRepo.createEmployee("Adam", "Adam", 20, new ArrayList<Phone>(), 1200).getSurname());
//		String name = "Adam";
//		String surname = "Adamczyk";
//		int age = 20;
//		int salary = 1200;
//		List<Phone> phoneList = new LinkedList<Phone>();
//		phoneList.add(new Phone("1888-888-888"));
//		phoneList.add(new Phone("1999-999-999"));
//		Employee employee = userRepo.createEmployee(employee.getName(), employee.getSurname(), age, phoneList, salary);
//		assertEquals(name, employee.getName());
//		assertEquals(surname, employee.getSurname());
//		assertEquals(age, employee.getAge());
		
	}

//	@Test
//	public void testCreateAdministrator() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSetLogger() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetLogger() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testCloseDatabaseConnection() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUpdateAge() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testFind() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testEqualsByID() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSelectItems() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSelectItemsHeaving() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSelectUsers() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSelectUsersHeaving() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testShowResults() {
//		fail("Not yet implemented");
//	}

}
