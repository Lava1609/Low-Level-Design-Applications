package TicketBookingSystem;

public class Ticket {
   private String username;
   private Event event;
   private String eventname;
   private int NoOfTickets;
   private String BookingId;
   private int ticketprice;
   
   public Ticket(String username, Event event ,int NoOfTickets) {
	   this.username=username;
	   this.event=event;
	   this.NoOfTickets=NoOfTickets;
	   this.eventname=event.getname();
	   this.BookingId="";
	   this.ticketprice=0;
   }
   
   public String getUsername() {
	   return username;
   }
   public String getEventDetails() {
	   return "name  --"+event.getname() +"         "+
              "location--"+event.getLocation()+"    "+
			   "Date--"+event.getDate()+"       "+
              "Timing--"+event.getTimeSlot()+"        "+
			   "Available Tickets--"+event.getAvailTickets()+"     "+
              "Ticket Price--"+event.getTicketPrice();
   }
   public String getEventname() {
	   return eventname;
   }
   public int getNoTickets() {
	   return NoOfTickets;
   }
   public int getPrice() {
	   return ticketprice;
   }
   public String getBookingId() {
	   return BookingId;
   }
   
   public void setBookingId(String bookingId) {
	   this.BookingId=bookingId;
   }
   public void setTicketprice(int price) {
	   this.ticketprice=price;
   }
}
