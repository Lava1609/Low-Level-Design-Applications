package CarRentalManagement;

import java.util.HashMap;
import java.util.Map;

public class CarRentalSystem {
	    private Map<String, Car> cars;
	    private Map<String, Customer> customers;
	    private Map<String, Rental> rentals;
        int counter=23;
       
	    public CarRentalSystem() {
	        this.cars = new HashMap<>();
	        this.customers = new HashMap<>();
	        this.rentals = new HashMap<>();
	    }

	    public void addCar(Car car) {
	        if (cars.containsKey(car.getCarId())) {
	            System.out.println("Car with this ID already exists.");
	            return;
	        }
	        cars.put(car.getCarId(), car);
	        System.out.println("Car added successfully.");
	    }

	    public void addCustomer(Customer customer) {
	        if (customers.containsKey(customer.getCustomerId())) {
	            System.out.println("Customer with this ID already exists.");
	            return;
	        }
	        customers.put(customer.getCustomerId(), customer);
	        System.out.println("Customer added successfully.");
	    }

	    public void rentCar( String carId, String customerId, String rentalStartDate, String rentalEndDate) {
	        Car car = cars.get(carId);
	        Customer customer = customers.get(customerId);
	        if (car == null || customer == null || !car.isAvailable()) {
	            System.out.println("Car or Customer not found, or Car is not available.");
	            return;
	        }
	       
            String rentalId="B"+counter++;
	        Rental rental = new Rental(rentalId, carId, customerId, rentalStartDate, rentalEndDate);
	        car.rentCar();
	        customer.rentCar(rental);
	        rentals.put(rentalId, rental);
	        System.out.println("Car rented successfully, and your rental Id   "+rentalId);
	    }

	    public void returnCar(String rentalId, String returnDate) {
	        Rental rental = rentals.get(rentalId);
	        if (rental == null) {
	            System.out.println("Rental ID not found.");
	            return;
	        }

	        Car car = cars.get(rental.getCarId());
	        Customer customer = customers.get(rental.getCustomerId());

	        rental.setReturnDate(returnDate);
	        rental.calculateTotalAmount(car.getDailyRentalPrice());

	        car.returnCar();
	        customer.returnCar(rental);
	        rentals.remove(rentalId);

	        System.out.println("Car returned successfully. Total amount due: " + rental.getTotalAmount());
	    }

	    public void printCarDetails() {
	        for (Car car : cars.values()) {
	            System.out.println("Car ID: " + car.getCarId() + ", Model: " + car.getModel() + ", Brand: " + car.getBrand() +
	                    ", Daily Rental Price: " + car.getDailyRentalPrice() + ", Available: " + car.isAvailable());
	        }
	        System.out.println("Total available cars: " + getTotalAvailableCars());
	        System.out.println("Total rented cars: " + getTotalRentedCars());
	    }

	    private int getTotalAvailableCars() {
	        int count = 0;
	        for (Car car : cars.values()) {
	            if (car.isAvailable()) {
	                count++;
	            }
	        }
	        return count;
	    }

	    private int getTotalRentedCars() {
	        return cars.size() - getTotalAvailableCars();
	    }

}
 