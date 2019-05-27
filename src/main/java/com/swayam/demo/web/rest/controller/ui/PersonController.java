package com.swayam.demo.web.rest.controller.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
		Person prsn = personservice.addPerson(person);
		return new ModelAndView("redirect:/ui/person/all");
	}

	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public ModelAndView addPerson() {
		return new ModelAndView("person", "personObj", new Person());
	}

	@RequestMapping(path = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView updatePerson(@PathVariable int id) {
		Person row = personservice.getSinglePerson(id);
		return new ModelAndView("update_person", "person", row);
	}

	@RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteStudent(@PathVariable int id) {
		int row = personservice.deletePerson(id);
		return new ModelAndView("redirect:/ui/person/all");
	}

	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public ModelAndView getAllPerson(@ModelAttribute Person person) {
		List<Person> lst = personservice.getAllPerson();
		return new ModelAndView("all_person", "personList", lst);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ModelAndView getSinglePerson(@PathVariable int id) {
		Person ps = personservice.getSinglePerson(id);
		return new ModelAndView("singleperson", "personsingle", ps);
	}

	@RequestMapping(path = "/single", method = RequestMethod.GET)
	public ModelAndView getSinglePersonDetails() {
		return new ModelAndView("singlepersonid", "person", new Person());
	}

}
