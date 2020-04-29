package com.sprinttech.dev.RestAPI;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

class EmployeeControllerTest {
	private EmployeeController ec;
	private List<Employee> listOfEmployees;

	@Before
	public void setUp() {
		ec = new EmployeeController();
		listOfEmployees = new ArrayList<Employee>();
		listOfEmployees.add(new Employee( "10", "Satvik", "Sonti", "test@t.com"));

	}
	@Ignore
 	public void getEmployeesNonEmptyTest()
	{
		ec.addEmployee(listOfEmployees);
		assertEquals("Expected list size doesnt match actual size", 1, ec.getEmployees().size());
	}

	@Ignore
	public void getEmployeesEmptyTest()
	{
		assertEquals(0, ec.getEmployees().size());
	}

	@Ignore
	public void addEmployeeEmptyTest()
	{
		assertEquals(0,ec.getEmployees().size());
		ec.addEmployee(listOfEmployees);
		assertEquals( 1, ec.getEmployees().size());

	}

	@Ignore
	public void addEmployeeNonEmptyTest() {

		assertEquals(0, ec.getEmployees().size());
		ec.addEmployee(listOfEmployees);
		assertEquals(1, ec.getEmployees().size());
		listOfEmployees.add(new Employee( "11","Sampath", "Sonti", "test@nonempty.com"));
		ec.addEmployee(listOfEmployees);
		assertEquals(2, ec.getEmployees().size());
	}

	@Ignore
	public void updateEmployeeEmptyTest()
	{
		ec.addEmployee(listOfEmployees);

		assertEquals(1, ec.getEmployees().size());
		ec.updateEmployee("11", new Employee( "11","Sampath", "Sonti", "new@update.com"));
		assertEquals(1, ec.getEmployees().size());
		assertEquals("Sampath", ec.getEmployees().get(0).getFirstName(), "First name doesnt match");
		assertEquals("new@update.com", ec.getEmployees().get(0).getEmail(), "Email doesnt match");
	}

	@Ignore
	public void updateEmployeeNonEmptyTest()
	{
		/* check if list is empty */
		assertEquals(0, ec.getEmployees().size());
		ec.updateEmployee("11", new Employee( "11","Sampath", "Sonti", "new@mt.com"));
		assertEquals(0, ec.getEmployees().size());

	}

}

