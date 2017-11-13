### Rental Car Application
## Spring Boot Project from November 11th

Requirements:

* Add a car to my fleet
* Assign a driver to the car (vehicle is not rentable)
* Accept Returning a Car (now it's rentable)
* Stretch Goal - in maintenance (not rentable / no driver)

Controllers: 

* RentalController

Classes:

* Car (make, model, year)
* Fleet (availableCar, unavailableCar)
* Person (firstName, lastName, licenseNumber, state)
* Rental (person, car)

ModelAndViews: 

* addCar
* rentCar
* returnCar

Templates:

* main
* addCarForm
* rentalForm