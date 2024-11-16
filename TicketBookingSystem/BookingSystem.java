package TicketBookingSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class BookingSystem {
    private Map<String, User> users;
    private List<Event> events;
    private List<Ticket> bookedTickets;

    public BookingSystem() {
        this.users = new HashMap<>();
        this.events = new ArrayList<>();
        this.bookedTickets = new ArrayList<>();
    }

    public void addNewUser(User user) {
        String mailId = user.getmailId();
        if (users.containsKey(mailId)) {
            System.out.println("Already registered!");
        } else {
            users.put(mailId, user);
            System.out.println("Successfully registered!");
        }
    }

    public String login(String mailId, String password) {
        User user = users.get(mailId);
        if (user != null && user.getpassword().equals(password)) {
            return user.getname();
        } else {
            System.out.println("Invalid user credentials.");
            return null;
        }
    }

    public void addEvents(Event event) {
        events.add(event);
        System.out.println("Event successfully added.");
    }

    public Event searchEvents(String choice) {
        for (Event e : events) {
            if (e.getname().equalsIgnoreCase(choice) || e.getLocation().equalsIgnoreCase(choice) ||
                e.getDate().equalsIgnoreCase(choice) || e.getTimeSlot().equalsIgnoreCase(choice)) {
                return e;
            }
        }
        return null;
    }

    public void printEventDetails(Event selectedEvent) {
        System.out.println(selectedEvent);
    }

    public boolean bookTickets(Ticket ticket) {
        String eventName = ticket.getEventname();
        Event event = null;
        for (Event e : events) {
            if (e.getname().equalsIgnoreCase(eventName)) {
                event = e;
                break;
            }
        }
        if (event != null) {
            int availableTickets = event.getAvailTickets();
            if (availableTickets >= ticket.getNoTickets()) {
            	String bookingId = UUID.randomUUID().toString();
                int price = event.getTicketPrice() * ticket.getNoTickets();
                ticket.setBookingId(bookingId);
                ticket.setTicketprice(price);
                bookedTickets.add(ticket);
                event.setAvailTickets(availableTickets - ticket.getNoTickets());
                System.out.println("Tickets booked successfully with Booking ID: " + bookingId);
                return true;
            } else {
                System.out.println("Insufficient tickets.");
                return false;
            }
        } else {
            System.out.println("Event not found.");
            return false;
        }
    }

    public void viewHistory(String name) {
        for (Ticket t : bookedTickets) {
            if (t.getUsername().equals(name)) {
                System.out.println("User: " + t.getUsername());
                System.out.println("Event Details: " + t.getEventDetails());
                System.out.println("Number of Tickets: " + t.getNoTickets());
                System.out.println("Booking ID: " + t.getBookingId());
                System.out.println("Price: " + t.getPrice());
                System.out.println("-------------------------------");
            }
        }
    }

    public boolean cancelBooking(String bookingId) {
        for (int i = 0; i < bookedTickets.size(); i++) {
            Ticket t = bookedTickets.get(i);
            if (t.getBookingId().equals(bookingId)) {
                Event event = searchEvents(t.getEventname());
                if (event != null) {
                    event.setAvailTickets(event.getAvailTickets() + t.getNoTickets());
                }
                bookedTickets.remove(i);
                System.out.println("Booking with ID " + bookingId + " cancelled successfully.");
                return true;
            }
        }
        System.out.println("Booking ID not found.");
        return false;
    }
}
