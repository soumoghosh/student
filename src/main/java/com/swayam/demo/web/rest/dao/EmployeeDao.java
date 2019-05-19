package com.swayam.demo.web.rest.dao;

import java.util.List;

import com.swayam.demo.web.rest.model.Employee;

public interface EmployeeDao {

	public Employee addEmployee(Employee employee);

	public Employee updateEmployee(int id);

	public List<Employee> allEmployee();

	public int deleteEmployee(int id);

	public Employee getEmployeeById(int id);

}
