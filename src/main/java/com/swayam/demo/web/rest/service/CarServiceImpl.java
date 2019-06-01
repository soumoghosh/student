package com.swayam.demo.web.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swayam.demo.web.rest.dao.CarDao;
import com.swayam.demo.web.rest.model.Car;

@Service
public class CarServiceImpl implements CarService {

	private CarDao carDao;

	@Autowired
	public CarServiceImpl(CarDao carDao) {

		this.carDao = carDao;
	}

	@Transactional
	@Override
	public Car addNewCar(Car car) {

		if (carDao.checkExistCar(car.getName())) {
			return carDao.updateCar(car);
		} else
			return carDao.addNewCar(car);
	}

	@Transactional
	@Override
	public int deleteCar(int id) {
		return carDao.deleteCar(id);
	}

	@Override
	public List<Car> getAllCarList() {
		return carDao.getAllCarList();
	}

	@Override
	public Car getSingleCar(int id) {
		return carDao.getSingleCar(id);
	}

	/*
	 * @Override public Car getSingleCar(String name) { return
	 * carDao.getSingleCar(name); }
	 */

}
