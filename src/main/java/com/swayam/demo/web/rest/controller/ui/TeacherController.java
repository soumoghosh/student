package com.swayam.demo.web.rest.controller.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.swayam.demo.web.rest.model.Teacher;
import com.swayam.demo.web.rest.service.TeacherService;

@RequestMapping(path = "/ui/teacher")
@Controller
public class TeacherController {

	private TeacherService teacherservice;

	@Autowired
	public TeacherController(TeacherService teacherservice) {
		this.teacherservice = teacherservice;
	}

	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public ModelAndView addteacher() {
		return new ModelAndView("add_teacher", "teacherObj", new Teacher());
	}

	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public ModelAndView saveTeacher(@ModelAttribute Teacher teacher) {
		Teacher teacher1 = teacherservice.addTeacher(teacher);
		return new ModelAndView("redirect:/ui/teacher/all");
	}

	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public ModelAndView getAllteacher() {
		List<Teacher> listteacher = teacherservice.allTeacher();
		System.out.println(listteacher.size());
		return new ModelAndView("all_teacher", "teacherList", listteacher);
	}

	@RequestMapping(path = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView updateTeacher(@PathVariable int id) {
		Teacher teacher = teacherservice.getSingleTeacher(id);
		return new ModelAndView("update_teacher", "teacher", teacher);
	}

	@RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteTeacher(@PathVariable int id) {
		int row = teacherservice.deleteTeacher(id);
		return new ModelAndView("redirect:/ui/teacher/all");
	}

	@RequestMapping(path = "/single/{id}", method = RequestMethod.GET)
	public ModelAndView getSingleTeacher(@PathVariable int id) {
		Teacher teacher = teacherservice.getSingleTeacher(id);
		return new ModelAndView("single_teacher", "teacher", teacher);
	}
}
