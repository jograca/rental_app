package com.lmig.gcf.rentals.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gcf.rentals.models.Car;
import com.lmig.gcf.rentals.models.Fleet;

@Controller
public class RentalController {

	// Set a private variable for Fleet
	private Fleet fleet;

	// Constructor - setup an instance of the Fleet object
	// So we can setup private variables that need values
	public RentalController() {
		fleet = new Fleet();
	}

	@RequestMapping("/")
	public ModelAndView showMainPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("fleet", fleet);
		return mv;
	}

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

	@RequestMapping("/rentCar")
	public ModelAndView rentOutACar(int index) {
		
		fleet.rentOutCar(index -1);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");
		return mv;
	}
	
	@RequestMapping("/returnCar")
	public ModelAndView returnCar(int index) {
		
		fleet.makeCarAvailable(index -1);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");
		return mv;
	}
}
