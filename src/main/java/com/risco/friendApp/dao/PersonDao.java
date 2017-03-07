package com.risco.friendApp.dao;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.risco.friendApp.model.Person;

@Repository
public class PersonDao extends JdbcDaoSupport {
	
    @Autowired 
    private DataSource dataSource;
    
    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }
    
    public ArrayList<Person> getPersons() {
		String sql = "SELECT * FROM person";
		ArrayList<Person> personList = (ArrayList<Person>) getJdbcTemplate().query(sql, new PersonRowMapper());
		return personList;
	}

    public Person getPersonByLogin(String login) {
		String sql = "SELECT * FROM person WHERE login = ?";
		try {
			Person person = (Person) getJdbcTemplate().queryForObject(sql, new Object[] {login}, new PersonRowMapper());
			return person;			
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

    public void updatePersonByLogin(Person person) {
		String sql = "UPDATE person SET name = ?, age = ?, salary = ?, birthDate = ? WHERE login = ?";
		getJdbcTemplate().update(sql, new Object[] {person.getName(), person.getAge(), 
				person.getSalary(), person.getBirthDate(), person.getLogin()});		
	}
    
    public void persistPerson(Person person) {
		String sql = "INSERT INTO person (login, name, password, age, salary, birthDate) VALUES (?, ?, ?, ?, ?, ?)";
		getJdbcTemplate().update(sql, new Object[] {person.getLogin(), person.getName(), 
				person.getPassword(), person.getAge(), person.getSalary(), person.getBirthDate()});	
    }
    
    public void deletePerson(String login) {
    	String sql = "DELETE FROM person WHERE login = ?";
    	getJdbcTemplate().update(sql, new Object[] {login});
    }

}
