package com.swayam.demo.web.rest.dao;

import java.util.List;

import com.swayam.demo.web.rest.model.Car;

public interface CarDao {

	public Car addNewCar(Car car);

	public Car updateCar(Car car);

	public int deleteCar(int id);

	public List<Car> getAllCarList();

	public Car getSingleCar(int id);

	public boolean checkExistCar(String name);

	// public Car getSingleCar(String name);

}
