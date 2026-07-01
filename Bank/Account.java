package Bank;

public class Account {
    // 1. Core fields set to protected so child classes can use them directly
    protected String accountHolderName;
    protected int accountNumber;
    protected double balance;
    

    // 2. Main constructor - sets up name, number, and checks for negative starting balance
    public Account(String name, int accountNo, double accountbalance) {
        this.accountHolderName = name;
        this.accountNumber = accountNo;
        
        if (accountbalance >= 0) {
            this.balance = accountbalance;
        } else {
            System.out.println("Invalid balance amount!! Defaulting the balance to $0.0");
            this.balance = 0.0;
        }
    }

    // Standard deposit method
    public void deposit(double amount) {
        if (amount > 0) { 
            this.balance = this.balance + amount;
            System.out.println("Amount deposited successfully: $" + amount);
        } else {
            System.out.println("Rejected!! You cannot deposit negative or zero amount.");
        }        
    }

    // Standard withdraw method
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Rejected!! You cannot withdraw negative or zero amount of money.");
        } else if (amount <= balance) {
            this.balance = this.balance - amount;
            System.out.println("Amount withdrew Successfully: $" + amount);
        } else {
            System.out.println("Transaction denied! Insufficient funds for withdrawal.");
        }           
    }

    // Base layout to display account summary
    public void displayAccountDetails() {
        System.out.println("\n═══════════════════════════════");
        System.out.println("Account Holder:  " + this.accountHolderName);
        System.out.println("Account Number:  " + this.accountNumber);
        System.out.println("Balance:         $" + this.balance);
        System.out.println("═══════════════════════════════");
    }

    // Getters for safely fetching data
    public String getAccountHolderName() {
        return this.accountHolderName;
    }

    public double getBalance() {
        return this.balance;
    }
}