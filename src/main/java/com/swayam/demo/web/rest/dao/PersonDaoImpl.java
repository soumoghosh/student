package com.swayam.demo.web.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.swayam.demo.web.rest.model.Person;

@Repository
public class PersonDaoImpl implements PersonDao {

	private JdbcTemplate jdbctemplate;

	@Autowired
	public PersonDaoImpl(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	@Override
	public Person addPerson(Person person) {
		String sql = "insert into person2 (name,age) values(?,?)";
		KeyHolder generatedKeyholder = new GeneratedKeyHolder();
		jdbctemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement preparedstatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				preparedstatement.setString(1, person.getName());
				preparedstatement.setInt(2, person.getAge());
				return preparedstatement;
			}
		}, generatedKeyholder);
		int id = generatedKeyholder.getKey().intValue();
		person.setId(id);
		return person;
	}

	@Override
	public List<Person> getAllPerson() {
		String sql = "select * from person2";
		return jdbctemplate.query(sql, new RowMapper<Person>() {

			@Override
			public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
				Person person = new Person();
				person.setAge(rs.getInt("age"));
				person.setId(rs.getInt("id"));
				person.setName(rs.getString("name"));

				return person;
			}

		});

	}

	@Override
	public int deletePerson(int id) {
		String sql = "delete from person2 where id=?";
		int row = jdbctemplate.update(sql);

		return row;
	}

	@Override
	public Person updatePerson(int id) {
		Person ps = new Person();
		String sql = "update person2 set name=?,age=? where id=?";
		int row = jdbctemplate.update(sql, ps.getAge(), ps.getName(), ps.getId());
		return ps;
	}

}
