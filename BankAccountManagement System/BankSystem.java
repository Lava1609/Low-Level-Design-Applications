package BankAccountManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankSystem {
	
	    private Map<String, User> users;
	    private List<Transaction> transactions;
	    private List<Admin> admins;

	    public BankSystem() {
	        this.users = new HashMap<>();
	        this.transactions = new ArrayList<>();
	        this.admins = new ArrayList<>();
	    }

	    public void addAdmin(Admin admin) {
	        admins.add(admin);
	    }

	    public Admin authenticateAdmin(String username, String password) {
	        for (Admin admin : admins) {
	            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
	                return admin;
	            }
	        }
	        return null;
	    }

	    public void addUserAccount(User user) {
	        if (users.containsKey(user.getAccountNumber())) {
	            System.out.println("Account already exists!");
	        } else {
	            users.put(user.getAccountNumber(), user);
	            System.out.println("Account created successfully!");
	        }
	    }

	    public void deleteUserAccount(String accountNumber) {
	        if (users.remove(accountNumber) != null) {
	            System.out.println("Account deleted successfully!");
	        } else {
	            System.out.println("Account not found!");
	        }
	    }

	    public void updateUserAccount(String accountNumber, String newName, String newPin) {
	        User user = users.get(accountNumber);
	        if (user != null) {
	            user.setName(newName);
	            user.setPin(newPin);
	            System.out.println("Account updated successfully!");
	        } else {
	            System.out.println("Account not found!");
	        }
	    }

	    public User authenticateUser(String accountNumber, String pin) {
	        User user = users.get(accountNumber);
	        if (user != null && user.getPin().equals(pin)) {
	            return user;
	        }
	        return null;
	    }

	    public void checkBalance(User user) {
	        System.out.println("Current Balance: " + user.getCurrentBalance());
	    }

	    public void checkBalance(String accountNumber) {
	        User user = users.get(accountNumber);
	        if (user != null) {
	            System.out.println("Current Balance: " + user.getCurrentBalance());
	        } else {
	            System.out.println("Account not found!");
	        }
	    }

	    public void depositMoney(User user, int amount) {
	        user.setCurrentBalance(user.getCurrentBalance() + amount);
	        transactions.add(new Transaction(user.getAccountNumber(), "Deposit", amount));
	        System.out.println("Amount deposited successfully!");
	    }

	    public void withdrawMoney(User user, int amount) {
	        if (user.getCurrentBalance() >= amount) {
	            user.setCurrentBalance(user.getCurrentBalance() - amount);
	            transactions.add(new Transaction(user.getAccountNumber(), "Withdraw", amount));
	            System.out.println("Amount withdrawn successfully!");
	        } else {
	            System.out.println("Insufficient balance!");
	        }
	    }

	    public void transferMoney(User user, String recipientAccount, int amount) {
	        User recipient = users.get(recipientAccount);
	        if (recipient != null && user.getCurrentBalance() >= amount) {
	            user.setCurrentBalance(user.getCurrentBalance() - amount);
	            recipient.setCurrentBalance(recipient.getCurrentBalance() + amount);
	            transactions.add(new Transaction(user.getAccountNumber(), "Transfer to " + recipientAccount, amount));
	            transactions.add(new Transaction(recipientAccount, "Transfer from " + user.getAccountNumber(), amount));
	            System.out.println("Amount transferred successfully!");
	        } else {
	            System.out.println("Transfer failed. Check recipient account and balance.");
	        }
	    }

	    public void viewAllTransactions() {
	        for (Transaction transaction : transactions) {
	            System.out.println(transaction);
	        }
	    }

	    public void viewTransactionHistories(String accountNumber) {
	        for (Transaction transaction : transactions) {
	            if (transaction.getAccountNumber().equals(accountNumber)) {
	                System.out.println(transaction);
	            }
	        }
	    }

	    public void userDetailsList() {
	        for (User user : users.values()) {
	            System.out.println(user);
	        }
	    }

	    public void setActiveStatus(String accountNumber, boolean status) {
	        User user = users.get(accountNumber);
	        if (user != null) {
	            user.setActive(status);
	            System.out.println("Account status updated successfully!");
	        } else {
	            System.out.println("Account not found!");
	        }
	    }

	    public void printAccountDetails(User user) {
	        System.out.println(user);
	    }
	}


