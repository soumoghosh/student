package com.swayam.demo.web.rest.controller.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.swayam.demo.web.rest.model.Employee;
import com.swayam.demo.web.rest.service.EmployeeService;

@RequestMapping(path = "/ui/employee")
@Controller
public class EmployeeController {

	private EmployeeService emplservice;

	@Autowired
	public EmployeeController(EmployeeService emplservice) {
		this.emplservice = emplservice;
	}

	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public ModelAndView addEmployee() {

		return new ModelAndView("employee", "employeeObj", new Employee());
	}

	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
		Employee empl = emplservice.addEmployee(employee);
		return new ModelAndView("redirect:/ui/employee/all");
	}

	@RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(@PathVariable int id) {
		int row = emplservice.deleteEmployee(id);
		return new ModelAndView("redirect:/ui/employee/all");
	}

	@RequestMapping(path = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView updateEmployee(@PathVariable int id) {
		Employee emp = emplservice.getEmployeeById(id);
		return new ModelAndView("update_employee", "employee", emp);
	}

	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public ModelAndView getAllEmployee(@ModelAttribute Employee employee) {
		List<Employee> listEmployee = emplservice.allEmployee();
		return new ModelAndView("all_employee", "employeeObj", listEmployee);
	}

	@RequestMapping(path = "/single/{id}", method = RequestMethod.GET)
	public ModelAndView getSingleEmployee(@PathVariable int id) {
		Employee employee = emplservice.getEmployeeById(id);
		return new ModelAndView("single_employee", "singleemployee", employee);
	}
}
