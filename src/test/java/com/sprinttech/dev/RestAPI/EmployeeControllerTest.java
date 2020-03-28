package com.sprinttech.dev.RestAPI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class EmployeeControllerTest {
	private EmployeeController ec;

	@BeforeEach
	public void setUp() {
		ec = new EmployeeController();
	}
	@Test
 	public void getEmployeesNonEmptyTest()
	{
		ec.addEmployee(new Employee(21, "Satvik", "Sonti", "test@t.com"));
		assertEquals(1, ec.getEmployees().size(), "Expected list size doesnt match actual size");
	}

	@Test
	public void getEmployeesEmptyTest()
	{
		assertEquals(0, ec.getEmployees().size(), "Expected list size match actual size");
	}

	@Test
	public void addEmployeeEmptyTest()
	{
		assertEquals(0,ec.getEmployees().size(), "List  empty");
		ec.addEmployee(new Employee(21, "Satvik", "Sonti", "test@mt.com"));
		assertEquals( 1, ec.getEmployees().size(), "1 employee added");

	}

	@Test
	public void addEmployeeNonEmptyTest() {

		assertEquals(0, ec.getEmployees().size(), "List  empty");
		ec.addEmployee(new Employee(21, "Satvik", "Sonti", "test@nonempty.com"));
		assertEquals(1, ec.getEmployees().size(), "1 new employee added");
		ec.addEmployee(new Employee(22, "Sampath", "Sonti", "test@nonempty.com"));
		assertEquals(2, ec.getEmployees().size(), "2 new employees added");
	}

	@Test
	public void updateEmployeeEmptyTest()
	{
		ec.addEmployee(new Employee(21, "Satvik", "Sonti", "test@nonempty.com"));

		assertEquals(1, ec.getEmployees().size(), "1 employee in List");
		ec.updateEmployee(21, new Employee(21, "Sampath", "Sonti", "new@update.com"));
		assertEquals(1, ec.getEmployees().size(), "1 employee in List");
		assertEquals("Sampath", ec.getEmployees().get(0).getFirstName(), "First name doesnt match");
		assertEquals("new@update.com", ec.getEmployees().get(0).getEmail(), "Email doesnt match");
	}

	@Test
	public void updateEmployeeNonEmptyTest()
	{
		/* check if list is empty */
		assertEquals(0, ec.getEmployees().size(), "List  empty");
		ec.updateEmployee(10, new Employee(10, "Sampath", "Sonti", "new@mt.com"));
		assertEquals(0, ec.getEmployees().size(), "List not empty");

	}

}

