package com.swayam.demo.web.rest.service;

import java.util.List;

import com.swayam.demo.web.rest.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployee();

	boolean saveEmployee(Employee empl);
	
	

	boolean deleteEmployee(int id);
	
	
}
