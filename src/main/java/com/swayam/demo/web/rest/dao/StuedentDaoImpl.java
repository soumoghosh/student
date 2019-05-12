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

import com.swayam.demo.web.rest.model.Student;

@Repository
public class StuedentDaoImpl implements StudentDao {

	private JdbcTemplate jdbctemplate;

	@Autowired
	public StuedentDaoImpl(JdbcTemplate jdbctemplate) {
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
		String sql = "insert into student(name,age) values(?,?)";
		// int row = jdbctemplate.update(sql, student.getName(),
		// student.getAge());

		KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
		jdbctemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

				PreparedStatement preparedstatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				preparedstatement.setString(1, student.getName()); // database
																	// key is
																	// auto
																	// increment
																	// so to get
																	// that key
																	// we have
																	// used this
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
		// String sql = "update student set name=?,age=? where id= " +
		// student.getId() + "";
		// or
		String sql = "update student set name=?,age=? where id=?";
		// int row = jdbctemplate.update(sql, student.getName(),
		// student.getAge());
		// or
		int row = jdbctemplate.update(sql, student.getName(), student.getAge(), student.getId());
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

}
