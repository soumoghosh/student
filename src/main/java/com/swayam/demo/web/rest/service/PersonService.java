package com.swayam.demo.web.rest.service;

import java.util.List;

import com.swayam.demo.web.rest.model.Person;

public interface PersonService {

	public Person addPerson(Person person);

	public List<Person> getAllPerson();

	public int deletePerson(int id);

	// public Person updatePerson(int id);

	public Person getSinglePerson(int id);

	// public Person getPersonById(int id);

}
