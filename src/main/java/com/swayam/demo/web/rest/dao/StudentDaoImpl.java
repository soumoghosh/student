package com.swayam.demo.web.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.swayam.demo.web.rest.controller.rest.StudentRestController;
import com.swayam.demo.web.rest.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	private final Logger LOGGER = LoggerFactory.getLogger(StudentRestController.class);
	private JdbcTemplate jdbctemplate;

	@Autowired
	public StudentDaoImpl(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	@Override
	public List<Student> getAllStudent() {

		String sql = "select * from student";

		return jdbctemplate.query(sql, new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student st = new Student();
				st.setId(rs.getInt("id"));
				st.setName(rs.getString("name"));
				st.setAge(rs.getInt("age"));

				return st;

			}

		});
	}

	@Override
	public int deleteStudent(int id) {

		String sql = "delete from student where id=" + id + "";
		int row = jdbctemplate.update(sql);
		return row;
	}

	@Override
	public Student createStudent(Student student) {
		String sql2 = "insert into student(name,age) values(?,?)";
		// int row = jdbctemplate.update(sql, student.getName(),
		// student.getAge());

		KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
		jdbctemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

				PreparedStatement preparedstatement = con.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
				preparedstatement.setString(1, student.getName()); // database
																	// key
																	// is
																	// auto
																	// increment
																	// so to
																	// get
																	// that
																	// key
																	// we
																	// have
																	// used
																	// this
				preparedstatement.setInt(2, student.getAge());
				return preparedstatement;

			}
		}, generatedKeyHolder);
		int id = generatedKeyHolder.getKey().intValue();
		student.setId(id);
		return student;
	}

	@Override
	public Student updateStudent(Student student) {

		String sql = "update student set age=? where name=?";

		int row = jdbctemplate.update(sql, student.getAge(), student.getName());
		return student;
	}

	@Override
	public Student getStudentById(int id) {
		String sql = "select * from student where id=?";
		return jdbctemplate.queryForObject(sql, new Object[] { id }, new RowMapper<Student>() {
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setAge(rs.getInt("age"));
				return student;
			}

		});

	}

	@Override
	public boolean checkExistStudent(String name) {
		String sql = "select count(*) from student where name= ?";
		int count = jdbctemplate.queryForObject(sql, Integer.class, name);
		return count == 1;
	}

	@Override
	public Student getStudentByname(String name) {

		String sql = "select * from student where name=?";
		return jdbctemplate.queryForObject(sql, new Object[] { name }, new RowMapper<Student>() {
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setAge(rs.getInt("age"));
				return student;
			}

		});
	}

}
