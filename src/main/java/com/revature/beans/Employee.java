package com.revature.beans;

public class Employee {

	private int employeeId;
	private String firstName;
	private String lastName;
	private String department;

	public Employee(int employeeId, String firstName, String lastName, String department) {
		setEmployeeId(employeeId);
		setFirstName(firstName);
		setLastName(lastName);
		setDepartment(department);
	}
	
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public static Employee getDummy() {
		return new Employee(-1, "none", "none", "none");
	}

}
