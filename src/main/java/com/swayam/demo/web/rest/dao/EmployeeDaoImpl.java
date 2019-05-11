package com.swayam.demo.web.rest.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.swayam.demo.web.rest.model.Employee;
import com.swayam.demo.web.rest.model.Person;
@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	  private final JdbcTemplate jdbctemplate;

	    @Autowired
	    public EmployeeDaoImpl(JdbcTemplate jdbctemplate) {
	        this.jdbctemplate = jdbctemplate;
	    }

	@Override
	public List<Employee> getAllEmployee() {
		String sql = "select * from employee";
		List<Employee> empl = jdbctemplate.query(sql, new RowMapper<Employee>(){
			
			@Override
			public Employee mapRow(ResultSet rs, int rownum) throws SQLException {  // this maprow we can write in different class also we have to call that class
				
				Employee emp = new Employee();
				int id= rs.getInt("id");
				emp.setId(id);
				String firstName= rs.getString("firstname"); // this firstname is same as database name
				emp.setFirstname(firstName);
				String lastname= rs.getString("lastname");
				emp.setLastname(lastname);
				
				
				
				return emp;
			}
		});
		return empl;
			
		}
	@Override
	public boolean insertEmployee(Employee empl) {
		String sql="insert into employee (firstname,lastname,id) values(?,?,?)";
		int row = jdbctemplate.update(sql,empl.getFirstname(),empl.getLastname(),empl.getId() );
		
		return row==1; //row ==1 means one row is affected and it will return 1
		
	}

	@Override
	public boolean updateEmployee(Employee empl) {
		String sql = "update employee set firstname = ?" + "," + "lastname= ?" + "where id= ?";
		int row = jdbctemplate.update(sql, empl.getFirstname(),empl.getLastname(),empl.getId());
		return row==1;
	}
	
    @Override
    public boolean deleteEmployee(int id) {
    	
    	//Employee empl = new Employee();
    	String sql= "delete employee where id=?";
		int row = jdbctemplate.update(sql,id);
		return row==1;
    	
    }

	@Override
	public boolean checkExistEmployee(int id) {
		
		String sql = "select count( *) from employee where id= ?";
		int count  = jdbctemplate.queryForObject(sql, Integer.class, id);//
		
		return count== 1; 
			
	}
	

}
