package com.swayam.demo.web.rest.controller.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.swayam.demo.web.rest.model.Student;
import com.swayam.demo.web.rest.service.StudentService;

@RequestMapping(path = "/rest") // this is for http://localhost:8090/student
								// before student rest should be there and it is
								// applicable only for this controller
@RestController
public class StudentRestController {

	private final Logger LOGGER = LoggerFactory.getLogger(StudentRestController.class);

	private StudentService studentservice;

	@Autowired
	public StudentRestController(StudentService studentservice) {
		this.studentservice = studentservice;
	}

	@RequestMapping(path = "/student", method = RequestMethod.GET)
	public List<Student> getAllStudent() {
		List<Student> lst = studentservice.getAllStudent();
		return lst;
	}

	@RequestMapping(path = "/create", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public Student createStudentByForm(@ModelAttribute Student student) {
		LOGGER.info("input student: {}", student);
		Student add = studentservice.createStudent(student);
		return add;
	}

	@RequestMapping(path = "/create/json", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Student createStudentByJson(@RequestBody Student student) {
		LOGGER.info("input student: {}", student);
		Student add = studentservice.createStudent(student);
		return add;
	}

}
