package TicketBookingSystem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookingSystem booking = new BookingSystem();

        // Add events to browse
        initializeEvents(booking);

        // Register a user
        initializeUsers(booking);

        // Login and main menu loop
        String name = "";
        while (true) {
            System.out.println("Enter mailId:");
            String mailId = sc.nextLine();
            System.out.println("Enter Password:");
            String password = sc.nextLine();

            if (booking.login(mailId, password) != null) {
                name = booking.login(mailId, password);
                System.out.println("Successfully logged in --- Welcome " + name);

                boolean exit = false;
                while (!exit) {
                    exit = mainMenu(name, booking, sc);
                }
                break;
            } else {
                System.out.println("Invalid credentials. Please try again.");
            }
        }

        sc.close();
    }

    private static void initializeEvents(BookingSystem booking) {
        booking.addEvents(new Event("Rock Concert", "Madison Square Garden, NY", 15, 75, "2024-08-15", "Evening"));
        booking.addEvents(new Event("Tech Conference 2024", "San Francisco Convention Center, San Francisco", 20, 150, "2024-09-20", "Morning"));
        booking.addEvents(new Event("Broadway Show: Hamilton", "Richard Rodgers Theatre, NY", 25, 120, "2024-10-05", "Evening"));
        booking.addEvents(new Event("Food Festival", "Central Park", 50, 200, "2024-08-25", "Morning"));
        booking.addEvents(new Event("International Film Festival", "Dolby Theatre, Los Angeles, NY", 30, 250, "2024-09-01", "Evening"));
    }

    private static void initializeUsers(BookingSystem booking) {
        booking.addNewUser(new User("abc", "abc@gmail.com", "9876543210", "abc@123"));
        booking.addNewUser(new User("vfdc", "vfdc@gmail.com", "7658094443", "vfdc@897"));
    }

    private static boolean mainMenu(String name, BookingSystem booking, Scanner sc) {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1. Browse and Book Tickets");
        System.out.println("2. View Booking History");
        System.out.println("3. Cancel Booking");
        System.out.println("4. Exit");

        int choice;
        try {
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline
        } catch (InputMismatchException e) {
            sc.nextLine(); // Clear invalid input
            System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            return false;
        }

        switch (choice) {
            case 1:
                browseAndBookTickets(name, booking, sc);
                return false;
            case 2:
                booking.viewHistory(name);
                return false;
            case 3:
                cancelBooking(booking, sc);
                return false;
            case 4:
                System.out.println("Exiting... Thank you for using the ticket booking system!");
                return true;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                return false;
        }
    }

    private static void browseAndBookTickets(String name, BookingSystem booking, Scanner sc) {
        Event selectedEvent;
        boolean continueBrowsing = true;
        while (continueBrowsing) {
            System.out.println("--- Search for Your Favorite Show ---");
            String choice = sc.nextLine();
            selectedEvent = booking.searchEvents(choice);
            if (selectedEvent == null) {
                System.out.println("Sorry, the event you searched for is not available. Please try again.");
            } else {
                booking.printEventDetails(selectedEvent);
                System.out.println("Do you want to book tickets for this event? Enter 1 for Yes, 0 for No:");
                int n = sc.nextInt();
                sc.nextLine(); // Consume newline
                if (n == 1) {
                    System.out.println("Enter the number of tickets you want to book:");
                    int tickets = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    boolean success = booking.bookTickets(new Ticket(name, selectedEvent, tickets));
                    if (!success) {
                        System.out.println("Insufficient tickets available.");
                    } else {
                        System.out.println("Tickets booked successfully!");
                    }
                }
                continueBrowsing = false;
            }
            System.out.println("-------------------------------------------------------------");
        }
    }

    private static void cancelBooking(BookingSystem booking, Scanner sc) {
        System.out.println("Enter Booking ID to cancel:");
        String bookingId = sc.nextLine();
        boolean success = booking.cancelBooking(bookingId);
        if (!success) {
            System.out.println("Invalid Booking ID.");
        }
    }
}
