package com.swayam.demo.web.rest.dao;

import java.util.List;

import com.swayam.demo.web.rest.model.Person;

public interface PersonDao {

    List<Person> getPersons();

    boolean savePerson(Person person);


	boolean deletePerson(int id);

	List<Person> getAllPerson();
}
