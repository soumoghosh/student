package com.swayam.demo.web.rest.service;

import java.util.List;

import com.swayam.demo.web.rest.model.Car;

public interface CarService {

	public Car addNewCar(Car car);

	public int deleteCar(int id);

	public List<Car> getAllCarList();

	public Car getSingleCar(int id);

	// public Car getSingleCar(String name);

}
