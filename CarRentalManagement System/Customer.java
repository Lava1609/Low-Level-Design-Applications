package CarRentalManagement;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerId;
    private String name;
    private List<Rental> rentedCars;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.rentedCars = new ArrayList<>();
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public void rentCar(Rental rental) {
        rentedCars.add(rental);
    }

    public void returnCar(Rental rental) {
        rentedCars.remove(rental);
    }

    public List<Rental> getRentedCars() {
        return rentedCars;
    }
}
