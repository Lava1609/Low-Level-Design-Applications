package BankAccountManagement;

public class User {
    private String name;
    private String accountNumber;
    private String pin;
    private int initialBalance;
    private int currentBalance;
    private boolean isActive;
    private String password;

    public User(String name, String accountNumber, String pin, int initialBalance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.initialBalance = initialBalance;
        this.currentBalance = initialBalance;
        this.isActive = true;
        this.password = pin; // Initially, PIN and password are the same
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public int getInitialBalance() {
        return initialBalance;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", currentBalance=" + currentBalance +
                ", isActive=" + isActive +
                '}';
    }
}
