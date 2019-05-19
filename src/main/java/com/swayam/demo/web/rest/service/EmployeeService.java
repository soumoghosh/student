package com.swayam.demo.web.rest.service;

import java.util.List;

import com.swayam.demo.web.rest.model.Employee;

public interface EmployeeService {
	public Employee addEmployee(Employee employee);

	public Employee updateEmployee(int id);

	public List<Employee> allEmployee();

	public int deleteEmployee(int id);

	public Employee getEmployeeById(int id);
}
