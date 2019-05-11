package com.swayam.demo.web.rest.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.swayam.demo.web.rest.model.Student;
@Repository
public class StuedentDaoImpl implements StudentDao{

	private JdbcTemplate jdbctemplate;

	@Autowired
	public StuedentDaoImpl(JdbcTemplate jdbctemplate) {
		 this.jdbctemplate=jdbctemplate;
	}
	
	@Override
	public List<Student> getAllStudent() {
		
		String sql = "select * from student";
		
		return jdbctemplate.query(sql, new RowMapper<Student>()
		{

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
	public int  deleteStudent(int id) {
		
		String sql = "delete student where id=" + id +"";
		int row = jdbctemplate.update(sql);
		return row;
	}

	@Override
	public Student createStudent(Student student) {
		String sql = "insert into student(name,age) values(?,?)";
		int row = jdbctemplate.update(sql, student.getName(),student.getAge());
		return student;
	}


	@Override
	public int updateStudent(Student student) {
		String sql = "update student set id=?,name=?,age=?";
		int row = jdbctemplate.update(sql, student.getId(),student.getName(),student.getAge() );
		return row;
	}

}
