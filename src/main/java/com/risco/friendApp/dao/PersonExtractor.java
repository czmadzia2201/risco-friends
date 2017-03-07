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
public class PersonExtractor implements ResultSetExtractor<Person>{

	private PersonRowMapper personRowMapper = new PersonRowMapper();
	
	@Override
	public Person extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<String> phoneNumbers = new ArrayList<String>();
		Person person = null;
		while (rs.next()) {
			if (person == null) {
				person = personRowMapper.mapRow(rs, rs.getRow());
			}
			if (rs.getString("phoneNumber")!=null) {
				phoneNumbers.add(rs.getString("phoneNumber"));
			}
			person.setPhoneNumbers(phoneNumbers);
		}
		return person;
	}

}
