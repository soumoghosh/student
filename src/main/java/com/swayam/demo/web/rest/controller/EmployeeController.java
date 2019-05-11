package com.swayam.demo.web.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.swayam.demo.web.rest.service.*;
import com.swayam.demo.web.rest.model.*;

@Controller
public class EmployeeController {

	
	private final EmployeeService emplservice;
	@Autowired
	public EmployeeController(EmployeeService emplservice) {
		this.emplservice=emplservice;
	}
	
	@RequestMapping(path= "/employee", method = RequestMethod.GET)
	 public ModelAndView showNewEmployeePage(){
		return new ModelAndView("employee", "employee", new Employee());
		
	}
	
	@RequestMapping(path = "/employee", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView addEmployee(@ModelAttribute Employee employee) {
        emplservice.saveEmployee(employee);
        return new ModelAndView("employee", "employee", employee);
    }
	
	@RequestMapping(path = "/employee/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView deleteEmployee(@ModelAttribute int  id){
    	emplservice.deleteEmployee(id);
		return new ModelAndView("employee", "employee", deleteEmployee(id)); 
     }
	
	@RequestMapping(path = "/employee/all" , method = RequestMethod.GET)
    public ModelAndView getAllEmployee(@ModelAttribute Employee employee){
    	List<Employee> lst = emplservice.getAllEmployee();
		return new ModelAndView("employee" , "employee",lst);
	}
	

	
}
