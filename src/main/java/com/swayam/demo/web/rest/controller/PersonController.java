package com.swayam.demo.web.rest.controller;

import java.awt.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ModelAndViewResolverMethodReturnValueHandler;

import com.swayam.demo.web.rest.model.Person;
import com.swayam.demo.web.rest.service.PersonService;

@Controller
public class PersonController {

    private PersonService personservice;
    

    @Autowired
    public PersonController(PersonService personservice) {
        this.personservice = personservice;
    }

    @RequestMapping(path = { "person.jsp", "person.html", "person" }, method = { RequestMethod.GET })
    public ModelAndView showAddPersonPage() {
        return new ModelAndView("person");
    }

    @RequestMapping(path = "/person", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView addPerson(@ModelAttribute Person person) {
        personservice.savePerson(person);
        return new ModelAndView("person", "person", person);
    }
    
    @RequestMapping(path = "/person/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView deletePerson(@ModelAttribute int  id){
    	personservice.deletePerson(id);
		return new ModelAndView("person", "person", deletePerson(id)); 
     }

    @RequestMapping(path = "/user" , method = RequestMethod.GET)
    public ModelAndView getAllPerson(@ModelAttribute Person person){
    	java.util.List<Person> person1 =personservice.getAllPerson();
		return new ModelAndView();
    }
    
    
}
