package BankAccountManagement;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        BankSystem bank = new BankSystem();

        // Add admin user
        bank.addAdmin(new Admin("Admin", "admin", "admin123"));
        bank.addUserAccount(new User("abc","TRE123456","4567",500));
        bank.addUserAccount(new User("fdr","WER123456","7897",900));
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter login type (1 for Admin, 2 for User): ");
        int loginType = sc.nextInt();
        sc.nextLine(); // Consume newline

        if (loginType == 1) {
            System.out.println("Enter Admin username: ");
            String username = sc.nextLine();
            System.out.println("Enter Admin password: ");
            String password = sc.nextLine();

            Admin admin = bank.authenticateAdmin(username, password);
            if (admin != null) {
                System.out.println("Admin login successful. Welcome " + admin.getName() + "!");
                adminMenu(bank, sc, admin);
            } else {
                System.out.println("Authentication failed.");
            }
        } else if (loginType == 2) {
            System.out.println("Enter Account Number: ");
            String accountNumber = sc.nextLine();
            System.out.println("Enter PIN: ");
            String pin = sc.nextLine();

            User authenticatedUser = bank.authenticateUser(accountNumber, pin);
            if (authenticatedUser != null) {
                System.out.println("Authentication successful. Welcome " + authenticatedUser.getName() + "!");
                userMenu(bank, sc, authenticatedUser);
            } else {
                System.out.println("Authentication failed.");
            }
        }
    }

    private static void adminMenu(BankSystem bank, Scanner sc, Admin admin) {
        while (true) {
            System.out.println("Admin Menu:");
            System.out.println("1. Add Account");
            System.out.println("2. Delete Account");
            System.out.println("3. Update Account");
            System.out.println("4. View All Transactions");
            System.out.println("5. Balance Enquiry");
            System.out.println("6. User Details List");
            System.out.println("7. Activate/Deactivate Account");
            System.out.println("8. View Transaction Histories");
            System.out.println("9. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter Name:");
                    String name = sc.nextLine();
                    System.out.println("Enter Account Number:");
                    String accountNumber = sc.nextLine();
                    System.out.println("Enter Initial Balance:");
                    int initialBalance = sc.nextInt();
                    System.out.println("Enter PIN:");
                    String pin = sc.next();
                    bank.addUserAccount(new User(name, accountNumber, pin, initialBalance));
                    break;
                case 2:
                    System.out.println("Enter Account Number:");
                    accountNumber = sc.nextLine();
                    bank.deleteUserAccount(accountNumber);
                    break;
                case 3:
                    System.out.println("Enter Account Number:");
                    accountNumber = sc.nextLine();
                    System.out.println("Enter New Name:");
                    String newName = sc.nextLine();
                    System.out.println("Enter New PIN:");
                    String newPin = sc.nextLine();
                    bank.updateUserAccount(accountNumber, newName, newPin);
                    break;
                case 4:
                    bank.viewAllTransactions();
                    break;
                case 5:
                    System.out.println("Enter Account Number:");
                    accountNumber = sc.nextLine();
                    bank.checkBalance(accountNumber);
                    break;
                case 6:
                    bank.userDetailsList();
                    break;
                case 7:
                    System.out.println("Enter Account Number:");
                    accountNumber = sc.nextLine();
                    System.out.println("Enter Status (true for active, false for inactive):");
                    boolean status = sc.nextBoolean();
                    bank.setActiveStatus(accountNumber, status);
                    break;
                case 8:
                    System.out.println("Enter Account Number:");
                    accountNumber = sc.nextLine();
                    bank.viewTransactionHistories(accountNumber);
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void userMenu(BankSystem bank, Scanner sc, User authenticatedUser) {
        while (true) {
            System.out.println("User Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transfer Money");
            System.out.println("5. View Statements");
            System.out.println("6. Account Details");
            System.out.println("7. Change Password");
            System.out.println("8. Change PIN");
            System.out.println("9. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    bank.checkBalance(authenticatedUser);
                    break;
                case 2:
                    System.out.println("Enter amount to deposit:");
                    int depositAmount = sc.nextInt();
                    bank.depositMoney(authenticatedUser, depositAmount);
                    break;
                case 3:
                    System.out.println("Enter amount to withdraw:");
                    int withdrawAmount = sc.nextInt();
                    bank.withdrawMoney(authenticatedUser, withdrawAmount);
                    break;
                case 4:
                    System.out.println("Enter recipient account number:");
                    String recipientAccount = sc.next();
                    System.out.println("Enter amount to transfer:");
                    int transferAmount = sc.nextInt();
                    bank.transferMoney(authenticatedUser, recipientAccount, transferAmount);
                    break;
                case 5:
                    bank.viewTransactionHistories(authenticatedUser.getAccountNumber());
                    break;
                case 6:
                    bank.printAccountDetails(authenticatedUser);
                    break;
                case 7:
                    System.out.println("Enter new password:");
                    String newPassword = sc.nextLine();
                    authenticatedUser.setPassword(newPassword);
                    break;
                case 8:
                    System.out.println("Enter new PIN:");
                    String newPin = sc.nextLine(); 
                    authenticatedUser.setPin(newPin);
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

}
        
