import java.util.ArrayList;

public class Account {

    private int accountNumber;
    private String name;
    private String password;
    private double balance;

    // Mini Statement
    private ArrayList<String> miniStatement = new ArrayList<>();

    // Constructor
    public Account(int accountNumber, String name, String password, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.password = password;
        this.balance = balance;

        // Record account creation
        miniStatement.add("Account Created with Initial Balance : ₹" + balance);
    }

    // Getters
    public int getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    // Add transaction to mini statement
    public void addTransaction(String transaction) {
        miniStatement.add(transaction);
    }

    // Deposit
    public void deposit(double amount) {

        if (amount > 0) {

            balance += amount;

            addTransaction("Deposited : ₹" + amount);

            System.out.println("₹" + amount + " Deposited Successfully.");

        } else {

            System.out.println("Invalid Deposit Amount.");

        }
    }

    // Withdraw
    public void withdraw(double amount) {

        if (amount <= 0) {

            System.out.println("Invalid Withdrawal Amount.");

        } else if (amount <= balance) {

            balance -= amount;

            addTransaction("Withdrawn : ₹" + amount);

            System.out.println("₹" + amount + " Withdrawn Successfully.");

        } else {

            System.out.println("Insufficient Balance.");

        }
    }

    // Display Mini Statement
    public void showMiniStatement() {

        System.out.println("\n========== MINI STATEMENT ==========");

        if (miniStatement.isEmpty()) {

            System.out.println("No Transactions Found.");

        } else {

            for (String transaction : miniStatement) {

                System.out.println(transaction);

            }

        }

        System.out.println("------------------------------------");
        System.out.println("Current Balance : ₹" + balance);
        System.out.println("====================================");
    }

    // Display Account Details
    public void showDetails() {

        System.out.println("\n------ ACCOUNT DETAILS ------");

        System.out.println("Account Number : " + accountNumber);
        System.out.println("Name           : " + name);
        System.out.println("Balance        : ₹" + balance);

        System.out.println("-----------------------------");
    }
}