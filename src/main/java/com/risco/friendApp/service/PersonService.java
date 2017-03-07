package com.risco.friendApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.risco.friendApp.dao.PersonDao;
import com.risco.friendApp.model.Person;

@Service
public class PersonService {
	
	@Autowired
	private PersonDao personDao;
	
	public List<Person> getPersons() {
		return personDao.getPersons();
	}
	
	public Person getPersonByLogin(String login) {
		return personDao.getPersonByLogin(login);
	}
	
	public void updatePersonByLogin(Person person) {
		Person current = personDao.getPersonByLogin(person.getLogin());
		current.setName(person.getName());
		current.setAge(person.getAge());
		current.setSalary(person.getSalary());
		current.setBirthDate(person.getBirthDate());
		personDao.updatePersonByLogin(current);	
	}
	
	public void persistPerson(Person person) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		person.setPassword(passwordEncoder.encode(person.getPassword()));
		personDao.persistPerson(person);	
	}
	
	public void deletePerson(String login) {
		personDao.deletePerson(login);	
	}

}
