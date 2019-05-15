package com.swayam.demo.web.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swayam.demo.web.rest.dao.PersonDao;
import com.swayam.demo.web.rest.model.Person;

@Service
public class PersonServiceImpl implements PersonService {

	private PersonDao persondao;

	@Autowired
	public PersonServiceImpl(PersonDao persondao) {
		this.persondao = persondao;
	}

	@Transactional
	@Override
	public Person AddPerson(Person person) {
		return persondao.addPerson(person);
	}

	@Override
	public List<Person> getAllPerson() {
		return persondao.getAllPerson();
	}

	@Transactional
	@Override
	public int deletePerson(int id) {
		return persondao.deletePerson(id);
	}

	@Transactional
	@Override
	public Person updatePerson(int id) {
		return persondao.updatePerson(id);
	}

}
