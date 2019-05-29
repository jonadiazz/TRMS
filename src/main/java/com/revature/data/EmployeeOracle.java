package com.revature.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.beans.Employee;
import com.revature.utils.ConnectionUtil;

public class EmployeeOracle implements EmployeeDAO {

	private static Logger log = Logger.getLogger(EmployeeOracle.class);
	private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	
	@Override
	public Employee getEmployee(int employeeId) {
		Employee employee = null;
		
		String selectSQL = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID = ?";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try(Connection conn = cu.getConnection()) {
			
			preparedStatement = conn.prepareStatement(selectSQL);
			
			preparedStatement.setInt(1, employeeId);
			
			rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				log.info("Retrieving employee");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String department = rs.getString("department");

				employee = new Employee(employeeId, firstName, lastName, department);
				
			} else {
				log.info("Employee not found");
				employee = Employee.getDummy();
			}
			
		} catch (SQLException e) {
			log.warn("There was a problem trying to retrieve employee");
		} catch (Exception e) {
			log.warn("Random exception", e);
			employee = Employee.getDummy();

		}
		
		return employee;
	}

}
