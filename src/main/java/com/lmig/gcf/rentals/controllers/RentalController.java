package com.lmig.gcf.rentals.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gcf.rentals.models.Car;
import com.lmig.gcf.rentals.models.Fleet;
import com.lmig.gcf.rentals.models.Person;

@Controller
public class RentalController {

	// Set a private variable for Fleet
	private Fleet fleet;

	// Constructor - setup an instance of the Fleet object
	// So we can setup private variables that need values
	public RentalController() {
		fleet = new Fleet();
	}

	// main.html

	@RequestMapping("/")
	public ModelAndView showMainPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("fleet", fleet);
		return mv;
	}

	// Called by clicking Rent Car on main

	@RequestMapping("/rentCar")
	public ModelAndView rentCar(int index, String firstName, String lastName, String licenseNumber, String state) {

		Person renter = new Person(firstName, lastName, licenseNumber, state);
		fleet.rentOutCar(index - 1, renter);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");

		return mv;
	}

	// Called by Clicking "Return Car" on main

	@RequestMapping("/returnCar")
	public ModelAndView returnCar(int index) {

		fleet.makeCarAvailable(index - 1);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");
		return mv;
	}

	// Called by Clicking "Rent Out This Car" on main

	@RequestMapping("/rental")
	public ModelAndView showRentFormForCar(int index) {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("rentalForm");

		Car car = fleet.getAvailableCars().get(index -1);
		mv.addObject("car", car);
		mv.addObject("index", index);

		return mv;
	}
	
	// Called by clicking Add Car on Add Car Form
	
	@RequestMapping("/addCar")
	public ModelAndView showAddCarForm(String make, String model, String year) {

		if (make != null && !make.isEmpty() && model != null && !model.isEmpty() && year != null && !year.isEmpty()) {

			Car car = new Car(make, model, year);
			fleet.addCar(car);

			ModelAndView mv = new ModelAndView();
			mv.setViewName("redirect:/");
			return mv;
		}

		ModelAndView mv = new ModelAndView();
		mv.setViewName("addCarForm");
		return mv;
	}
}
