package com.risco.friendApp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.risco.friendApp.model.Person;

public class PersonRowMapper implements RowMapper<Person> {

	@Override
	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
		Person person = new Person();
		person.setLogin(rs.getString("login"));
		person.setName(rs.getString("name"));
		person.setAge(rs.getInt("age"));
		person.setSalary(rs.getInt("salary"));
		return person;
	}

}
