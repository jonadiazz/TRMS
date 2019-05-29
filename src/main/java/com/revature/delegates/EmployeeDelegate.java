package com.revature.delegates;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employee;
import com.revature.services.EmployeeService;
import com.revature.services.EmployeeServiceOracle;
import com.revature.utils.JsonParseUtil;

public class EmployeeDelegate implements FrontControllerDelegate {

	private Logger log = Logger.getLogger(EmployeeDelegate.class);
	private EmployeeService employeeService = new EmployeeServiceOracle();
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Override
	public void process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		String path = (String) req.getAttribute("path");
		log.trace(path);
		
		if (null == path || "".equals(path)) {
			collectionOperations(req, resp);
		}
//		} else {
			
//		}
	}
	
	private void collectionOperations(HttpServletRequest req, HttpServletResponse resp) throws JsonProcessingException, IOException {
		switch(req.getMethod()) {
		case "GET":
			log.trace("Retrieving a list of all employees");
			Employee employee = employeeService.getEmployee(30);
			resp.getWriter().write(objectMapper.writeValueAsString(employee));
			break;
		case "POST":
			log.trace("Posting an employee to db.");

			Employee empl;
			empl = JsonParseUtil.parseJsonInput(req.getInputStream(), Employee.class, resp);
			if(null == empl) 
				return;
			
//			employeeService.addEmployee();// if ever implemented
//			resp.setStatus(HttpServletResponse.SC_CREATED);
//			resp.getWriter().write(om.writeValueAsString(a));
		}
	}

}
