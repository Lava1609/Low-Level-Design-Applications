package ATM;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	ATMInterface atm=new ATMInterface();
    	
    	//ADD A USER IN ATM
    	atm.addUserAccount(new User("Abc","ABC123456","2525",500));
    	atm.addUserAccount(new User("Ced","TED567890","2003",1000));
    	atm.addUserAccount(new User("Cat","GAT987424","1609",1500));
    	
    	Scanner sc=new Scanner(System.in);
    	System.out.println("Enter a Bank Account Number ");
    	String accountNumber=sc.nextLine();
    	System.out.println("Enter a pin");
    	String pin=sc.nextLine();
    	
    	User Authenticateduser=atm.authenticateUser(accountNumber,pin);
    	if(Authenticateduser!=null) {
    		System.out.println("Authentication is successuful welcome , happy transaction"+Authenticateduser.getName());
    		while(true) {
    			System.out.println("choose an option to proceed");
    			System.out.println("1.checkBalance");
    			System.out.println("2.Deposit Money");
    			System.out.println("3.Withdraw Money");
    			System.out.println("4.Transfer Money");
    			System.out.println("5.Exit");
    			
    			int ch=sc.nextInt();
    			switch(ch){
    			case 1:
    				atm.checkBalance(Authenticateduser);
    				break;
    				
    			case 2:
    				System.out.println("Enter money to deposit");
    				int amt=sc.nextInt();
    				atm.depositMoney(Authenticateduser,amt);
    				break;
    				
    			case 3:
    				System.out.println("Enter money to WithDraw");
    				int withdraw=sc.nextInt();
    				atm.withdrawMoney(Authenticateduser,withdraw);
    				break;
    				
    			case 4:
    				System.out.println("Enter the recipient account Number and money to transfer");
    				String account=sc.next();
    				System.out.println("Enter  money to transfer");
    				int money=sc.nextInt();
    				atm.transferMoney(Authenticateduser,account,money);
    				break;
    			case 5:
    			    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
    		}
    	}
    	}
    	atm.printAccountDetails();
    }
}
