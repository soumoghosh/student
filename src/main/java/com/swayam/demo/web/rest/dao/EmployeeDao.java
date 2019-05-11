package com.swayam.demo.web.rest.dao;
import com.swayam.demo.web.rest.model.Employee;

import java.util.List;

public interface EmployeeDao {
	
	List<Employee> getAllEmployee();

	boolean insertEmployee(Employee empl);
	
	boolean updateEmployee(Employee empl);

	boolean deleteEmployee(int id);
	
	boolean checkExistEmployee(int id);
	
}
