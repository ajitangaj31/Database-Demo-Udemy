package com.ajitangaj.database.databasedemo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ajitangaj.database.databasedemo.entity.Person;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PersonRepository {
	
	private final JdbcTemplate jdbcTemplate;
	
	class CustomPersonRowMapper implements RowMapper<Person>{

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			var person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			person.setBirthDate(rs.getTimestamp("birth_date"));
			return person;
		}
		
	}
	
	public List<Person> findAll(){
		return jdbcTemplate.query("select * from Person", new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	@SuppressWarnings("deprecation")
	public Person findById(int id){
		return jdbcTemplate.queryForObject("select * from Person where id = ?", new Object[] {id}, new CustomPersonRowMapper());
	}
	
	public int deleteById(int id){
		return jdbcTemplate.update("delete from Person where id = ?", new Object[] {id});
	}
	
	public void insert(Person person) {
		jdbcTemplate.update("insert into person(id, name, location, birth_date)"
				+ "values(?, ?, ?, ?)",
				new Object[] {person.getId(), person.getName(), person.getLocation(), person.getBirthDate()});
	}
	
	public void update(Person person) {
		jdbcTemplate.update("update person set name = ?, location = ?, birth_date = ?"
				+ "where id = ?",
				new Object[] {person.getName(), person.getLocation(), person.getBirthDate(), person.getId()});
	}
}
