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

import com.swayam.demo.web.rest.model.Teacher;

@Repository
public class TeacherDaoImpl implements TeacherDao {

	private JdbcTemplate jdbctemplate;

	@Autowired
	public TeacherDaoImpl(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	@Override
	public Teacher addTeacher(Teacher teacher) {

		String sql = "insert into teacher1 (name,dept,course) values(?,?,?)";

		KeyHolder generateKeyholder = new GeneratedKeyHolder();
		jdbctemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement preparedstatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				preparedstatement.setString(1, teacher.getName());
				preparedstatement.setString(2, teacher.getDept());
				preparedstatement.setString(3, teacher.getCourse());
				return preparedstatement;
			}
		}, generateKeyholder);
		int id = generateKeyholder.getKey().intValue();
		teacher.setId(id);
		return teacher;
	}

	@Override
	public List<Teacher> allTeacher() {
		String sql = "select * from teacher1";
		List<Teacher> list = jdbctemplate.query(sql, new RowMapper<Teacher>() {

			@Override
			public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
				Teacher teacher = new Teacher();
				teacher.setId(rs.getInt("id"));
				teacher.setName(rs.getString("name"));
				teacher.setDept(rs.getString("dept"));
				teacher.setCourse(rs.getString("course"));
				return teacher;
			}

		});
		return list;

	}

	@Override
	public Teacher updateTeacher(Teacher teacher) {
		String sql = "update teacher1 set name=?,dept=?,course=? where id=?";
		int row = jdbctemplate.update(sql, teacher.getName(), teacher.getDept(), teacher.getCourse(), teacher.getId());
		return teacher;

	}

	@Override
	public int deleteTeacher(int id) {
		String sql = "delete teacher1 where id =" + id;
		int row = jdbctemplate.update(sql);
		return row;
	}

	@Override
	public boolean checkExistTeacher(String name) {

		String sql = "select count(*) from teacher1 where name=?";
		int count = jdbctemplate.queryForObject(sql, Integer.class, name);
		if (count >= 1) {
			return true;
		} else
			return false;
	}

	@Override
	public Teacher getSingleTeacher(int id) {

		String sql = "select * from teacher1 where id=?";
		Teacher teacher = jdbctemplate.queryForObject(sql, new Object[] { id }, new RowMapper<Teacher>() {

			@Override
			public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
				Teacher teacher = new Teacher();
				teacher.setId(rs.getInt("id"));
				teacher.setName(rs.getString("name"));
				teacher.setDept(rs.getString("dept"));
				teacher.setCourse(rs.getString("course"));
				return teacher;

			}
		});
		return teacher;
	}

}
