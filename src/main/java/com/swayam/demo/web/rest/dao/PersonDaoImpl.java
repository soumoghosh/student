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

		String sql = "delete from person2 where id=" + id;
		int row = jdbctemplate.update(sql);

		return row;
	}

	@Override
	public Person updatePerson(Person person) {
		String sql = "update person2 set age=? where name=?";
		int row = jdbctemplate.update(sql, person.getAge(), person.getName());
		return person;
	}

	@Override
	public Person getSinglePerson(int id) {
		String sql = "select * from person2 where id=?";
		Person person = jdbctemplate.queryForObject(sql, new Object[] { id }, new RowMapper<Person>() {
			@Override

			public Person mapRow(ResultSet rs, int row) throws SQLException {
				Person prsn = new Person();
				prsn.setId(rs.getInt("id"));
				prsn.setName(rs.getString("name"));
				prsn.setAge(rs.getInt("age"));
				return prsn;
			}

		});
		return person;

	}

	@Override
	public boolean checkExistPerson(String name) {

		String sql = "select count(*) from person2 where name=?";
		int count = jdbctemplate.queryForObject(sql, Integer.class, name);

		if (count >= 1) {
			return true;
		} else
			return false;
	}

	@Override
	public Person getPersonById(int id) {
		String sql = "select * from person2 where id=?";

		return jdbctemplate.queryForObject(sql, new Object[] { id }, new RowMapper<Person>() {

			@Override
			public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
				Person ps = new Person();
				ps.setId(rs.getInt("id"));
				ps.setName(rs.getString("name"));
				ps.setAge(rs.getInt("age"));
				return ps;
			}

		});
	}

}
