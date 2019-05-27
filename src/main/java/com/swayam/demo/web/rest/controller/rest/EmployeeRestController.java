package com.swayam.demo.web.rest.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.swayam.demo.web.rest.model.Employee;
import com.swayam.demo.web.rest.service.EmployeeService;

@RequestMapping(path = "/rest/employee")
@RestController
public class EmployeeRestController {

	private EmployeeService employeeservice;

	@Autowired
	public EmployeeRestController(EmployeeService employeeservice) {
		this.employeeservice = employeeservice;
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public Employee addEmployee(@ModelAttribute Employee employee) {
		Employee employee1 = employeeservice.addEmployee(employee);
		return employee1;
	}

	/*
	 * @RequestMapping(path = "/update/{id}", method = RequestMethod.PUT,
	 * consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE }) public
	 * Employee updateEmployee(@PathVariable int id) { Employee employee =
	 * employeeservice.updateEmployee(id); return employee; }
	 */

	@RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE, consumes = {
			MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public int deleteEmployee(@PathVariable int id) {
		int row = employeeservice.deleteEmployee(id);
		return row;
	}

	@RequestMapping(path = "/single/{id}", method = RequestMethod.GET, consumes = {
			MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public Employee getSingleEmployee(@PathVariable int id) {
		Employee empl = employeeservice.getEmployeeById(id);
		return empl;
	}
}
