package com.swayam.demo.web.rest.controller.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.swayam.demo.web.rest.model.Car;
import com.swayam.demo.web.rest.service.CarService;

@RequestMapping(path = "/ui/car")
@Controller
public class CarController {

	private CarService carSevice;

	@Autowired
	public CarController(CarService carSevice) {
		this.carSevice = carSevice;
	}

	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public ModelAndView addCar() {
		return new ModelAndView("add_car", "carObj", new Car());
	}

	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public ModelAndView saveCar(@ModelAttribute Car car) {
		Car car1 = carSevice.addNewCar(car);
		return new ModelAndView("redirect:/ui/car/all");
	}

	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public ModelAndView getAllCar(@ModelAttribute Car car) {
		List<Car> listCar = carSevice.getAllCarList();
		return new ModelAndView("all_car", "carList", listCar);
	}

	@RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteCar(@PathVariable int id) {
		int row = carSevice.deleteCar(id);
		return new ModelAndView("redirect:/ui/car/all");
	}

	@RequestMapping(path = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView updateCar(@PathVariable int id) {
		Car car = carSevice.getSingleCar(id);
		return new ModelAndView("update_car", "carObj", car);
	}

	@RequestMapping(path = "/single/{id}", method = RequestMethod.GET)
	public ModelAndView getSingleCar(@PathVariable int id) {
		Car car = carSevice.getSingleCar(id);
		return new ModelAndView("single_car", "carObj", car);
	}

}