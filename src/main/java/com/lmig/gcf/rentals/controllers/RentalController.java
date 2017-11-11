package com.lmig.gcf.rentals.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gcf.rentals.models.Car;

@Controller
public class RentalController {

	@RequestMapping("/")
	public ModelAndView showMainPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/addCar")
	public ModelAndView showAddCarForm(String make, String model, String year) {

		if (make != null && !make.isEmpty() && model != null && !model.isEmpty() && year != null && !year.isEmpty()) {

			Car car = new Car(make, model, year);
		}

		ModelAndView mv = new ModelAndView();
		mv.setViewName("addCarForm");
		return mv;
	}

	@RequestMapping("/carInfo")
	public ModelAndView showCarInfoForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("carInfoForm");
		return mv;
	}
}
