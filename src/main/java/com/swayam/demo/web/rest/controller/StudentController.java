package com.swayam.demo.web.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.swayam.demo.web.rest.model.Student;
import com.swayam.demo.web.rest.service.StudentService;

@Controller
public class StudentController {

	private StudentService studentservice;
	
	@Autowired
	public StudentController(StudentService studentservice)
	{
		this.studentservice=studentservice;
	}
	
	@RequestMapping(path="/student" , method = RequestMethod.GET)
	
		public ModelAndView showStudentPage()
		{
			return new ModelAndView("student" , "student",new Student());
		}
	
	@RequestMapping(path="/student/all" , method = RequestMethod.GET)
	
	public ModelAndView getAllStudent(@ModelAttribute Student student)
	{
		List<Student> lst = studentservice.getAllStudent();
		return new ModelAndView("student","student",lst);
		
	}
	
	@RequestMapping(path="/create" , method = RequestMethod.POST)
	
	public ModelAndView createStudent(@ModelAttribute Student student)
	
	{
		studentservice.createStudent(student);
		
		return new ModelAndView("student","student",student);
	}
	
	@RequestMapping(path="/update" , method= RequestMethod.POST)
	
	public ModelAndView updateStudent(@ModelAttribute Student student)
	{
		studentservice.updateStudent(student);
		return new ModelAndView("student","student", student);
	}
	
	@RequestMapping(path="/delete/{id}" , method= RequestMethod.POST)
	public ModelAndView delete(@ModelAttribute int id)
	{
		int counter =studentservice.deleteStudent(id);
		if (counter>0)
		return new ModelAndView("student" , "student" , id );
		else
			return new ModelAndView();
		
	} 
}
