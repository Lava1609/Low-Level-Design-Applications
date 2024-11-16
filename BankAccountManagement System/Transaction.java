package BankAccountManagement;

import java.util.Date;

class Transaction {
    private String accountNumber;
    private String type;
    private int amount;
    private Date date;

    public Transaction(String accountNumber, String type, int amount) {
        this.accountNumber = accountNumber;
        this.type = type;
        this.amount = amount;
        this.date = new Date();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "accountNumber='" + accountNumber + '\'' +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
