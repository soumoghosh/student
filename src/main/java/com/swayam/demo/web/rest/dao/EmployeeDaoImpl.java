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

import com.swayam.demo.web.rest.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	private JdbcTemplate jdbctemplate;

	@Autowired
	public EmployeeDaoImpl(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	@Override
	public Employee addEmployee(Employee employee) {
		String sql = "insert into employee2 (name,age) values(?,?)";
		KeyHolder genaratekeyholder = new GeneratedKeyHolder();
		jdbctemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement preparestatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				preparestatement.setString(1, employee.getName());
				preparestatement.setInt(2, employee.getAge());
				return preparestatement;

			}

		}, genaratekeyholder);
		int id = genaratekeyholder.getKey().intValue();
		employee.setId(id);
		return employee;

	}

	@Override
	public Employee updateEmployee(int id) {
		String sql = "update employee2 set name=?,age=? where id=?";
		Employee employee = new Employee();
		int row = jdbctemplate.update(sql, employee.getId(), employee.getName(), employee.getAge());
		return employee;
	}

	@Override
	public List<Employee> allEmployee() {
		String sql = "select * from employee2";
		return jdbctemplate.query(sql, new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee employee = new Employee();
				employee.setName(rs.getString("name"));
				employee.setAge(rs.getInt("age"));
				employee.setId(rs.getInt("id"));

				return employee;
			}
		});
	}

	@Override
	public int deleteEmployee(int id) {
		String sql = "delete from employee2 where id=?";
		int row = jdbctemplate.update(sql);
		return row;
	}

	@Override
	public Employee getEmployeeById(int id) {
		String sql = "select * from employee2 where id =?";
		return jdbctemplate.queryForObject(sql, new Object[] { id }, new RowMapper<Employee>() {
			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee empl = new Employee();
				empl.setAge(rs.getInt("age"));
				empl.setId(rs.getInt("id"));
				empl.setName(rs.getString("name"));
				return empl;
			}
		});
	}

}
