package com.swayam.demo.web.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swayam.demo.web.rest.dao.EmployeeDao;
import com.swayam.demo.web.rest.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;

	@Autowired
	public EmployeeServiceImpl(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeDao.addEmployee(employee);
	}

	@Override
	public Employee updateEmployee(int id) {
		return employeeDao.updateEmployee(id);
	}

	@Override
	public List<Employee> allEmployee() {
		return employeeDao.allEmployee();
	}

	@Override
	public int deleteEmployee(int id) {
		return employeeDao.deleteEmployee(id);
	}

	@Override
	public Employee getEmployeeById(int id) {
		return employeeDao.getEmployeeById(id);
	}

}