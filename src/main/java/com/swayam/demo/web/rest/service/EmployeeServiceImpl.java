package com.swayam.demo.web.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swayam.demo.web.rest.dao.EmployeeDao;
import com.swayam.demo.web.rest.dao.PersonDao;
import com.swayam.demo.web.rest.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeDao empldao;

	@Autowired
	public EmployeeServiceImpl(EmployeeDao empldao) {
		this.empldao = empldao;
	}

	@Override
	public List<Employee> getAllEmployee() {

		return empldao.getAllEmployee();
	}

	@Transactional
	@Override
	public boolean saveEmployee(Employee empl) {

		if (empldao.checkExistEmployee(empl.getId())) {
			return empldao.updateEmployee(empl);
		} else {

			return empldao.insertEmployee(empl);
		}
	}

	@Override
	public boolean deleteEmployee(int id) {
		return empldao.deleteEmployee(id);
	}

}
