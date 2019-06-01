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

import com.swayam.demo.web.rest.model.Car;

@Repository
public class CarDaoImpl implements CarDao {

	private JdbcTemplate jdbctemplate;

	@Autowired
	public CarDaoImpl(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	@Override
	public Car addNewCar(Car car) {

		String sql = "insert into car (wheel,name,model)values(?,?,?)";
		KeyHolder generatedKeyHolder = new GeneratedKeyHolder();

		jdbctemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement preparestatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				preparestatement.setInt(1, car.getWheel());
				preparestatement.setString(2, car.getName());
				preparestatement.setString(3, car.getModel());
				return preparestatement;
			}
		}, generatedKeyHolder);
		int id = generatedKeyHolder.getKey().intValue();
		car.setId(id);
		return car;

	}

	@Override
	public Car updateCar(Car car) {

		String sql = "update car set wheel=?,model=? where name=?";
		int row = jdbctemplate.update(sql, car.getWheel(), car.getModel(), car.getName());
		return car;
	}

	@Override
	public int deleteCar(int id) {
		String sql = "delete from car where id =" + id;
		int row = jdbctemplate.update(sql);
		return row;
	}

	@Override
	public List<Car> getAllCarList() {
		String sql = "select * from car";
		List<Car> lst = jdbctemplate.query(sql, new RowMapper<Car>() {

			@Override
			public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
				Car car = new Car();
				car.setId(rs.getInt("id"));
				car.setWheel(rs.getInt("wheel"));
				car.setName(rs.getString("name"));
				car.setModel(rs.getString("model"));
				return car;
			}
		});
		return lst;
	}

	@Override
	public Car getSingleCar(int id) {

		String sql = "select * from car where id=?";
		Car car = jdbctemplate.queryForObject(sql, new Object[] { id }, new RowMapper<Car>() {

			@Override
			public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
				Car car = new Car();
				car.setId(rs.getInt("id"));
				car.setWheel(rs.getInt("wheel"));
				car.setName(rs.getString("name"));
				car.setModel(rs.getString("model"));
				return car;
			}

		});
		return car;
	};

	@Override
	public boolean checkExistCar(String name) {
		String sql = "select count(*) from car where name=?";
		int count = jdbctemplate.queryForObject(sql, Integer.class, name);
		if (count >= 1) {
			return true;
		}
		return false;
	}

	/*
	 * @Override public Car getSingleCar(String name) {
	 * 
	 * String sql = "select * from car where name=?"; return
	 * jdbctemplate.queryForObject(sql, new Object[] { name }, new
	 * RowMapper<Car>() {
	 * 
	 * @Override public Car mapRow(ResultSet rs, int rowNum) throws SQLException
	 * { Car car = new Car(); car.setWheel(rs.getInt("wheel"));
	 * car.setName(rs.getString("name")); car.setModel(rs.getString("model"));
	 * return car;
	 * 
	 * } });
	 * 
	 * }
	 */

}
