package TicketBookingSystem;

public class User {
    private String name;
    private String mailId;
    private String phNum;
    private String password;
    
    public User(String name,String mailId,String phNum,String password) {
    	this.name=name;
    	this.mailId=mailId;
    	this.phNum=phNum;
    	this.password=password;
    }
    
    public User() {
		
	}

	public String getname() {
    	return name;
    }
    
    public String getmailId() {
    	return mailId;
    }
    public String getphNum() {
    	return phNum;
    }
    
    public String getpassword() {
    	return  password;
    }
    
    public void setpassword(String password) {
    	this.password=password;
    }
    
    public void setmailId(String mailId) {
    	this.mailId=mailId;
    }
}
