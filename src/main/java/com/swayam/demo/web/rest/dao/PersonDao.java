package com.swayam.demo.web.rest.dao;

import java.util.List;

import com.swayam.demo.web.rest.model.Person;

public interface PersonDao {

	public Person addPerson(Person person);

	public List<Person> getAllPerson();

	public int deletePerson(int id);

	public Person updatePerson(Person person);

	public Person getSinglePerson(int id);

	boolean checkExistPerson(String name);

	public Person getPersonById(int id);

}
