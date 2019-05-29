package com.revature.services;

import com.revature.beans.Employee;
import com.revature.data.EmployeeDAO;
import com.revature.data.EmployeeOracle;

public class EmployeeServiceOracle implements EmployeeService {

	EmployeeDAO employeeDAO = new EmployeeOracle();

	@Override
	public Employee getEmployee(int employeeId) {

		return employeeDAO.getEmployee(employeeId);
	}

}
