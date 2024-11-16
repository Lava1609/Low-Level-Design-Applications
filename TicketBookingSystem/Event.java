package TicketBookingSystem;

public class Event {
   private String name;
   private String location;
   private int AvailTickets;
   private int ticketPrice;
   private String date;
   private String timeSlot;
   
   public Event(String name,String location,int AvailTickets,int ticketPrice,String date,String timeSlot) {
	   this.name=name;
	   this.location=location;
	   this.AvailTickets=AvailTickets;
	   this.ticketPrice=ticketPrice;
	   this.date=date;
	   this.timeSlot=timeSlot;
   }
   public String getname() {
	   return name;
   }
   public String getLocation() {
	   return location;
   }
   public int getAvailTickets() {
	   return AvailTickets;
   }
   public int getTicketPrice() {
	   return ticketPrice;
   }
   public String getDate() {
	   return date;
   }
   public String getTimeSlot() {
	   return timeSlot;
   }
   
   public String toString() {
	   return "Name : "+name+'\''+
			   "Location : "+location+'\''+
			   "Available Tickets : "+AvailTickets+'\''+
			   "Ticket Price : "+ticketPrice+'\''+
			   "Date : "+date+'\''+
			   "Time Slot : "+timeSlot;
   }
public void setAvailTickets(int i) {
	this.AvailTickets=i;
}
}
