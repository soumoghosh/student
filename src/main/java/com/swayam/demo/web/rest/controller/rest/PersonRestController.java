package com.swayam.demo.web.rest.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.swayam.demo.web.rest.model.Person;
import com.swayam.demo.web.rest.service.PersonService;

@RequestMapping(path = "/rest/person")
@RestController
public class PersonRestController {

	private PersonService personservice;

	@Autowired
	public PersonRestController(PersonService personservice) {
		this.personservice = personservice;
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public Person addPerson(@ModelAttribute Person person) {
		Person ps = personservice.AddPerson(person);
		return ps;
	}

	@RequestMapping(path = "/add/json", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Person addJsonPerson(@ModelAttribute Person person) {
		Person ps = personservice.AddPerson(person);
		return ps;
	}

	@RequestMapping(path = "/all", method = RequestMethod.GET, consumes = {
			MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public List<Person> getAllPerson(@ModelAttribute Person person) {
		List<Person> lst = personservice.getAllPerson();
		return lst;
	}

	@RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE, consumes = {
			MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public int deletePerson(@PathVariable int id) {
		int row = personservice.deletePerson(id);
		return row;
	}

	@RequestMapping(path = "/update/{id}", method = RequestMethod.PUT, consumes = {
			MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public Person updatePerson(@PathVariable int id) {
		Person person = personservice.updatePerson(id);
		return person;
	}
}
