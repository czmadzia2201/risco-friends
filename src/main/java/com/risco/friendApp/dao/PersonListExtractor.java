package com.risco.friendApp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.risco.friendApp.model.Person;

@Repository
public class PersonListExtractor implements ResultSetExtractor<List<Person>> {

	private PersonRowMapper personRowMapper = new PersonRowMapper();

	@Override
	public List<Person> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Person> persons = new ArrayList<Person>();
		List<String> phoneNumbers = null;
		Person person = null;
		String login = null;
		while (rs.next()) {
			if (person == null || !login.equals(rs.getString("login"))) {
				phoneNumbers = new ArrayList<String>();
				login = rs.getString("login");
				person = personRowMapper.mapRow(rs, rs.getRow());
				persons.add(person);
			}
			if (rs.getString("phoneNumber")!=null) {
				phoneNumbers.add(rs.getString("phoneNumber"));
			}
			person.setPhoneNumbers(phoneNumbers);
		}
		return persons;
	}
}
