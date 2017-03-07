package com.risco.friendApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.risco.friendApp.model.Person;
import com.risco.friendApp.service.PersonService;

@RestController
public class PersonsController {
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public ResponseEntity<List<Person>> getPersons() {
		List<Person> persons = personService.getPersons();
		return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
	}

	@RequestMapping(value = "/person/{login}", method = RequestMethod.GET)
	public ResponseEntity<Person> getPersonByLogin(@PathVariable(value = "login") String login) {
		Person person = personService.getPersonByLogin(login);
		if (person==null) {
			return new ResponseEntity<Person>(person, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/person/{login}", method = RequestMethod.PUT)
	public ResponseEntity<Person> updatePersonByLogin(
			@RequestHeader(value = "Authorization") String authorization,
			@PathVariable(value = "login") String login, 
			@RequestBody Person person) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null && auth.getName().equals(login)) {
			personService.updatePersonByLogin(person);
			return new ResponseEntity<Person>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Person>(HttpStatus.UNAUTHORIZED);
		}
	}
	        
	@RequestMapping(value = "/person", method = RequestMethod.POST)
	public ResponseEntity<Void> persistPerson(@RequestBody Person person) {
		if (personService.getPersonByLogin(person.getLogin())!=null)	
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		personService.persistPerson(person);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/person/{login}", method = RequestMethod.DELETE)
	public ResponseEntity<Person> deletePerson(
			@PathVariable(value = "login") String login,
			@RequestHeader(value = "Authorization") String authorization) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Person person = personService.getPersonByLogin(login);
		if (person==null) {
			return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
		} else if (auth != null && auth.getName().equals(login)) {
			personService.deletePerson(login);
			SecurityContextHolder.clearContext();
			return new ResponseEntity<Person>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Person>(HttpStatus.UNAUTHORIZED);
		}
	}
	
}