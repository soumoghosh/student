package com.swayam.demo.web.rest.service;

import java.util.List;

import com.swayam.demo.web.rest.model.Person;

public interface PersonService {
    boolean savePerson(Person person);

    String getPersons(Person person);

    boolean deletePerson(int id);
    
   List<Person> getAllPerson();
    
}
