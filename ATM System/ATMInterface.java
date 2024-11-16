package ATM;

import java.util.HashMap;
import java.util.Map;

public class ATMInterface {
	private Map<String,User> users;
	public ATMInterface() {
		this.users=new HashMap<>();
	}
	
	public void addUserAccount(User user) {
		if(users.containsKey(user.getaccountNumber())) {
			System.out.println("already created !");
			return;
		}
			users.put(user.getaccountNumber(), user);
			System.out.println("account created successfully  !!!");
	 }


	public User authenticateUser(String accountNumber, String pin) {
		User user=users.get(accountNumber);
		if(users.containsKey(accountNumber) && pin.equals(user.getPin()) ) {
			return user;
		}else {
		return null;
	}
	}

	public void checkBalance(User user) {
		int currentBalance=user.getCurrentBalance();
		System.out.println("Your Current Balance  --- "+currentBalance);
	}

	public void depositMoney(User user, int amt) {
		int Balance=user.getCurrentBalance();
		int newBalance=Balance+amt;
		user.setCurrentBalance(newBalance);
		System.out.println("Amount is credited successfully :) and your Current Balance  ---"+user.getCurrentBalance());
	}

	public void withdrawMoney(User user, int withdraw) {
		if(user.getCurrentBalance()<withdraw) {
			System.out.println("Insufficient amount in your Account ,sorry -_-");
		}else {
			int Balance=user.getCurrentBalance();
			int newBalance=Balance-withdraw;
			user.setCurrentBalance(newBalance);
			System.out.println("Amount is debited successfully :) and your Current Balance  ---"+user.getCurrentBalance());
		}
		
	}

	public void transferMoney(User user, String account, int money) {
		if(user.getCurrentBalance()<money) {
			System.out.println("Insufficient amount in your Account ,sorry -_-");
		}
		else {
			if(users.containsKey(account)) {
				User recipient=users.get(account);
				int recipientbalance=recipient.getCurrentBalance();
				int recipientnewBalance=recipientbalance+money;
				recipient.setCurrentBalance(recipientnewBalance);
				
				int senderBalance=user.getCurrentBalance();
				int sendernewBalance=senderBalance-money;
				user.setCurrentBalance(sendernewBalance);
				System.out.println("Amount transferred to recipient account successfully ");
				System.out.println("Sender Current Balance -----"+user.getCurrentBalance());
				System.out.println("Recipient Current Balance -----"+recipient.getCurrentBalance());
						
				
			}else {
				System.out.println("Invalid recipient account details and recipient account doesnot found check recipient account  number,SORRY    -_-");
			}
		}
	}

	public void printAccountDetails() {
		for(User user:users.values()) {
			System.out.println("NAME  ---"+user.getName());
			System.out.println("ACCOUNT NUMBER  ---"+user.getaccountNumber());
			System.out.println("PIN NUMBER  ---"+user.getPin());
			System.out.println("INITIAL BALANCE  --"+user.getInitialBalance());
			System.out.println("CURRENT BALANCE   ---"+user.getCurrentBalance());
		}
		
	}
	
	
}
