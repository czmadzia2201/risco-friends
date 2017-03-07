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
		String sql = "SELECT * FROM person LEFT JOIN phone ON person.login = phone.userLogin";
		ArrayList<Person> personList = (ArrayList<Person>) getJdbcTemplate().query(sql, new PersonListExtractor());
		return personList;
	}

    public Person getPersonByLogin(String login) {
		String sql = "SELECT * FROM person LEFT JOIN phone ON person.login = phone.userLogin WHERE login = ?";
		try {
			Person person = (Person) getJdbcTemplate().query(sql, new Object[] {login}, new PersonExtractor());
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
		String sql1 = "INSERT INTO person (login, name, password, age, salary, birthDate) VALUES (?, ?, ?, ?, ?, ?)";
		getJdbcTemplate().update(sql1, new Object[] {person.getLogin(), person.getName(), 
				person.getPassword(), person.getAge(), person.getSalary(), person.getBirthDate()});	
		if (person.getPhoneNumbers()!=null) {
			String sql2 = "INSERT INTO phone (phoneNumber, userLogin) VALUES (?, ?)";
			for (String phoneNumber : person.getPhoneNumbers()) {
				getJdbcTemplate().update(sql2, new Object[] {phoneNumber, person.getLogin()});
			}
		}		
    }
    
    public void deletePerson(String login) {
    	String sql1 = "DELETE FROM person WHERE login = ?";
    	getJdbcTemplate().update(sql1, new Object[] {login});
    	String sql2 = "DELETE FROM phone WHERE userLogin = ?";
    	getJdbcTemplate().update(sql2, new Object[] {login});
    }

}
