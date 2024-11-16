package CarRentalManagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CarRentalSystem system = new CarRentalSystem();

        // Add cars
        system.addCar(new Car("C1", "Model S", "Tesla", 100));
        system.addCar(new Car("C2", "Model 3", "Tesla", 80));

        // Add customers
        system.addCustomer(new Customer("U1", "Alice"));
        system.addCustomer(new Customer("U2", "Bob"));

        // Rent cars
        system.rentCar( "C1", "U1", "2024-07-01", "2024-07-05");
        system.rentCar( "C2", "U2", "2024-07-01", "2024-07-03");

        // Print car details
        system.printCarDetails();

        // Return cars
        system.returnCar("B23", "2024-07-06"); // 1 day delayed
        system.returnCar("B24", "2024-07-03");

        // Print car details after return
        system.printCarDetails();
    }
	
	 /*   public static void main(String[] args) {
	        CarRentalSystem system = new CarRentalSystem();
	        Scanner scanner = new Scanner(System.in);

	        while (true) {
	            System.out.println("1. Add Car");
	            System.out.println("2. Add Customer");
	            System.out.println("3. Rent Car");
	            System.out.println("4. Return Car");
	            System.out.println("5. Print Car Details");
	            System.out.println("6. Exit");
	            System.out.print("Choose an option: ");
	            int choice = scanner.nextInt();
	            scanner.nextLine();  // Consume newline

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter Car ID: ");
	                    String carId = scanner.nextLine();
	                    System.out.print("Enter Model: ");
	                    String model = scanner.nextLine();
	                    System.out.print("Enter Brand: ");
	                    String brand = scanner.nextLine();
	                    System.out.print("Enter Daily Rental Price: ");
	                    int dailyRentalPrice = scanner.nextInt();
	                    system.addCar(new Car(carId, model, brand, dailyRentalPrice));
	                    break;

	                case 2:
	                    System.out.print("Enter Customer ID: ");
	                    String customerId = scanner.nextLine();
	                    System.out.print("Enter Name: ");
	                    String name = scanner.nextLine();
	                    system.addCustomer(new Customer(customerId, name));
	                    break;

	                case 3:
	                    System.out.print("Enter Rental ID: ");
	                    String rentalId = scanner.nextLine();
	                    System.out.print("Enter Car ID: ");
	                    String rentCarId = scanner.nextLine();
	                    System.out.print("Enter Customer ID: ");
	                    String rentCustomerId = scanner.nextLine();
	                    System.out.print("Enter Rental Start Date (yyyy-mm-dd): ");
	                    String rentalStartDate = scanner.nextLine();
	                    System.out.print("Enter Rental End Date (yyyy-mm-dd): ");
	                    String rentalEndDate = scanner.nextLine();
	                    system.rentCar(rentalId, rentCarId, rentCustomerId, rentalStartDate, rentalEndDate);
	                    break;

	                case 4:
	                    System.out.print("Enter Rental ID: ");
	                    String returnRentalId = scanner.nextLine();
	                    System.out.print("Enter Return Date (yyyy-mm-dd): ");
	                    String returnDate = scanner.nextLine();
	                    system.returnCar(returnRentalId, returnDate);
	                    break;

	                case 5:
	                    system.printCarDetails();
	                    break;

	                case 6:
	                    scanner.close();
	                    System.exit(0);
	                    break;

	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }*/
}
