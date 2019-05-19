package com.swayam.demo.web.rest.controller.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.swayam.demo.web.rest.model.Person;
import com.swayam.demo.web.rest.service.PersonService;

@RequestMapping(path = "/ui/person")
@Controller
public class PersonController {

	private PersonService personservice;

	@Autowired
	public PersonController(PersonService personservice) {
		this.personservice = personservice;
	}

	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public ModelAndView addPerson(@ModelAttribute Person person) {
		Person prsn = personservice.AddPerson(person);
		return new ModelAndView("create_person", "person", prsn);
	}

	@RequestMapping(path = "/update/{id}", method = RequestMethod.POST)
	public ModelAndView updatePerson(@ModelAttribute int id) {
		Person row = personservice.updatePerson(id);
		return new ModelAndView("update_person", "person", row);
	}

	@RequestMapping(path = "/delete/{id}", method = RequestMethod.POST)
	public ModelAndView deleteStudent(@ModelAttribute int id) {
		int row = personservice.deletePerson(id);
		return new ModelAndView("delete_person", "person", row);
	}

	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public ModelAndView getAllPerson(@ModelAttribute Person person) {
		List<Person> lst = personservice.getAllPerson();
		return new ModelAndView("all_person", "student", lst);
	}
}
