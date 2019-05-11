package com.swayam.demo.web.rest.controller.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.swayam.demo.web.rest.model.Student;

@RequestMapping(path = "/ui/student") // this is for
										// http://localhost:8090/student
// before student ui should be there and it is
// applicable only for this controller
@Controller
public class StudentController {

	@RequestMapping(path = "/create", method = RequestMethod.GET)
	public ModelAndView showCreateStudentPage() {
		return new ModelAndView("create_student", "student", new Student());
	}

}
