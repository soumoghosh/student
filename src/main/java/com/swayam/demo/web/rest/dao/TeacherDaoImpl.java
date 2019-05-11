package com.swayam.demo.web.rest.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.swayam.demo.web.rest.model.Teacher;
@Repository
public class TeacherDaoImpl implements TeacherDao {
	
	private final JdbcTemplate jdbctemplate;
	@Autowired
	public TeacherDaoImpl(JdbcTemplate jdbcTemplate) {
            this.jdbctemplate=jdbcTemplate;
	}

	@Override
	public boolean addTeacher(Teacher teacher) {
		
		String insert= "insert into teacher (name,dept) values(?,?)";
		int row = jdbctemplate.update(insert,teacher.getName(),teacher.getDept());
		
		return row==1;
	}

	@Override
	public boolean deleteTeacher(int id) {
		
		String delete = "delete teacher where id=?";
		int row = jdbctemplate.update(delete,id);
		return row==1;
	}

	@Override
	public boolean updateTeacher(Teacher teacher) {
		String update= "update teacher set name=?" + "," +"dept=?" + "where id= ?";
		int row = jdbctemplate.update(update,teacher.getName(),teacher.getDept(),teacher.getId());
		return row==1;
	}

	@Override
	public List<Teacher> getAllTeacher() {
		String allteacher = "select * from teacher";
		List<Teacher> teacherlst = jdbctemplate.query(allteacher,new RowMapper<Teacher>() {
			
			
			@Override
			public Teacher mapRow(ResultSet rs, int rownum) throws SQLException {  // this maprow we can write in different class also we have to call that class
				
				Teacher emp = new Teacher();
				int id= rs.getInt("id");
				emp.setId(id);
				String name= rs.getString("name"); // this firstname is same as database name
				emp.setName(name);
				String dept= rs.getString("dept");
				emp.setDept(dept);
				
				
				
				return emp;
			}

			/*@Override
			public List<Teacher> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<Teacher> lst = new ArrayList<>();
				Teacher teacher1 = new Teacher();
				teacher1.setId(rs.getInt("id"));
				teacher1.setDept(rs.getString("dept"));
				teacher1.setName(rs.getString("name"));
				lst.add(teacher1);
				
				return lst;
			}*/
		});
		
		return teacherlst;
	}

	@Override
	public Teacher getSingleTeacherDeatils(int id) {
		String oneteacher = "select * from teacher where id= ?";
		Teacher teacher = (Teacher)jdbctemplate.query(oneteacher, new Object[]{id}, new RowMapper<Teacher>() {
		
			@Override
			public Teacher mapRow(ResultSet rs, int rownum) throws SQLException {  // this maprow we can write in different class also we have to call that class
				Teacher teacher1 = new Teacher();
				teacher1.setId(rs.getInt("id"));
				teacher1.setName(rs.getString("name"));
				teacher1.setDept(rs.getString("dept"));
				return teacher1;
	}
		});
		return teacher;
}

	@Override
	public boolean checkExistTeacher(int id) {

			String sql = "select count( *) from teacher where id= ?";
			int count  = jdbctemplate.queryForObject(sql, Integer.class, id);//
			
			return count== 1; 
				
		
	}
}
