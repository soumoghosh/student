package com.swayam.demo.web.rest.controller.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.swayam.demo.web.rest.model.Student;
import com.swayam.demo.web.rest.service.StudentService;

@RequestMapping(path = "/ui/student") // this is for
										// http://localhost:8090/student
// before student ui should be there and it is
// applicable only for this controller

@Controller
public class StudentController {

	private StudentService studentservice;

	@Autowired
	public StudentController(StudentService studentservice) {
		this.studentservice = studentservice;
	}

	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public ModelAndView showCreateStudentPage() {
		return new ModelAndView("student", "studentObject", new Student());
	}

	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public ModelAndView saveStudentDetails(@ModelAttribute Student student) {
		Student st = studentservice.createStudent(student);
		return new ModelAndView("redirect:/ui/student/all");
	}

	@RequestMapping(path = "/update/{name}", method = RequestMethod.GET)
	public ModelAndView updateStudentDetails(@PathVariable String name) {
		Student student = studentservice.getStudentByName(name);
		return new ModelAndView("student_update", "updateObject", student);
	}

	@RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteStudent(@PathVariable int id) {
		int row = studentservice.deleteStudent(id);
		return new ModelAndView("redirect:/ui/student/all");
	}

	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public ModelAndView getAllStudent(@ModelAttribute Student student) {
		List<Student> lst = studentservice.getAllStudent();
		return new ModelAndView("all_student", "studentList", lst);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ModelAndView getStudentById(@PathVariable int id) {
		Student st = studentservice.getStudentById(id);
		return new ModelAndView("single_student", "singlestudent", st);
	}
}
