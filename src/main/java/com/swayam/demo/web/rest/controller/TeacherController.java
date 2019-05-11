package com.swayam.demo.web.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.swayam.demo.web.rest.model.Teacher;
import com.swayam.demo.web.rest.service.TeacherService;


@Controller
public class TeacherController {

	private final TeacherService teacherservice;
	
	@Autowired
	public TeacherController(TeacherService teacherService)
	{
		this.teacherservice=teacherService;
	}
	
	
	@RequestMapping(path="/teacher" , method = RequestMethod.GET)
		public ModelAndView showTeacherPage()
		{
			return new ModelAndView("teacher","teacher",new Teacher());
		}
	
	@RequestMapping(path="/teacher" , method= RequestMethod.POST, consumes= MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView saveTeacher(@ModelAttribute Teacher teacher)
	{
		teacherservice.addTeacher(teacher);
		
		return new ModelAndView("teacher","teacher",teacher);
		
	}

	@RequestMapping(path="/teacher/{id}" , method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView deleteTeacher(@ModelAttribute int id)
	{
		teacherservice.deleteTeacher(id);
		return new ModelAndView("teacher","teacher",deleteTeacher(id));
	}

	@RequestMapping(path="/teacher/all" , method = RequestMethod.GET)
	public ModelAndView getAllTeacher(@ModelAttribute Teacher teacher)
	{
		List<Teacher> allteacher =teacherservice.getAllTeacher();
		return new ModelAndView("teacher" , "teacher",allteacher);
		
	}

	
}
