package BankAccountManagement;
public class Admin {
    private String name;
    private String username;
    private String password;

    public Admin(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    // Getters

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}