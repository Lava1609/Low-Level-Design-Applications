package ATM;

public class User {
      private String name;
      private String Number;
      private String pin;
      private int initialBalance;
      private int currentBalance;
      
      public User(String name,String Number,String pin,int i) {
    	  this.name=name;
    	  this.Number= Number;
    	  this.pin=pin;
    	  this.initialBalance=i;
    	  this.currentBalance=i;
      }
       
      public String getName() {
    	  return name;
      }
      
      public String getaccountNumber() {
    	  return Number;
      }
      
      public String getPin() {
    	  return pin;
      }
      
      public int getInitialBalance() {
    	  return initialBalance;
      }
      public int getCurrentBalance() {
    	  return currentBalance;
      }
      public void setCurrentBalance(int currentBalance) {
    	  this.currentBalance=currentBalance;
      }
}


