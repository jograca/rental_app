package com.lmig.gcf.rentals.models;

import java.util.ArrayList;

public class Fleet {

	private ArrayList<Car> availableCars;
	private ArrayList<Rental> unavailableCars;

	public Fleet() {
		availableCars = new ArrayList<Car>();
		unavailableCars = new ArrayList<Rental>();
	}

	public void addCar(Car car) {
		availableCars.add(car);
	}
	
	public void rentOutCar(int index, Person renter) {
		Car car = availableCars.remove(index);
		Rental rental = new Rental(car, renter);
		unavailableCars.add(rental);
	}

	public void makeCarAvailable(int index) {
		Rental rental = unavailableCars.remove(index);
		availableCars.add(rental.getVehicle());
	}	
		
	public ArrayList<Car> getAvailableCars() {
		return availableCars;
	}

	public ArrayList<Rental> getUnavailableCars() {
		return unavailableCars;
	}
	
}
