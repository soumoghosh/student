package com.swayam.demo.web.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swayam.demo.web.rest.dao.PersonDao;
import com.swayam.demo.web.rest.model.Person;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonDao persondao;

    @Autowired
    public PersonServiceImpl(PersonDao persondao) {
        this.persondao = persondao;
    }

    @Transactional
    @Override
    public boolean savePerson(Person person) {
        return persondao.savePerson(person);
    }

    @Override
    public String getPersons(Person person) {
        return null;
    }

	

	@Override
	public boolean deletePerson(int id) {
		return persondao.deletePerson(id);
	}

	@Override
	public List<Person> getAllPerson() {
		
		return persondao.getAllPerson();
	}
	
}
