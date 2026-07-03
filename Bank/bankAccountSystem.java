package Bank;
import java.util.ArrayList;

public class bankAccountSystem {
    // 1. Setting the fields protected
    protected String accountHolderName;
    protected int accountNumber;
    protected double balance;
    protected String accountType; 

    // Constructor
    public bankAccountSystem(String name, int accountNo, double accountbalance, String type) {
        this.accountHolderName = name;
        this.accountNumber = accountNo;
        
        setAccountType(type);
        if (accountbalance >= 0) {
            this.balance = accountbalance;
        } else {
            System.out.println("Invalid balance amount!! Defaulting the balance to $0.0");
            this.balance = 0.0;
        }
    }

    void deposit(double amount) {
        if (amount > 0) { 
            this.balance = this.balance + amount;
            System.out.println("Amount deposited successfully: $" + amount);
        } else {
            System.out.println("Rejected!! You cannot deposit negative or zero amount.");
        }         
    }

    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Rejected!! You cannot withdraw negative or zero amount of money.");
        } else if (amount <= balance) {
            this.balance = this.balance - amount;
            System.out.println("Amount withdrew Successfully: $" + amount);
        } else {
            System.out.println("Transaction denied! Insufficient funds for withdrawal.");
        }            
    }

    void displayAccountDetails() {
        System.out.println("\n═══════════════════════════════");
        System.out.println("Account Holder:  " + this.accountHolderName);
        System.out.println("Account Number:  " + this.accountNumber);
        System.out.println("Account Type:    " + this.accountType);
        System.out.println("Balance:         $" + this.balance);
        System.out.println("═══════════════════════════════");
    }

    public String getaccountHolderName() {
        return this.accountHolderName;
    }

    public double getBalance() {
        return this.balance;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public void setAccountType(String type) {
        if (type.equalsIgnoreCase("Savings") || type.equalsIgnoreCase("Current")) {
            this.accountType = type;
        } else {
            System.out.println("Invalid Account Type! Defaulting to Savings.");
            this.accountType = "Savings";
        }
    }

    public static void main(String[] args) {
        System.out.println("--- TASK 2: BANKING SYSTEM POLYMORPHIC ARRAY --- \n");

        // 1. FIXED: Changed data type to bankAccountSystem to match file class name
        ArrayList<bankAccountSystem> accounts = new ArrayList<>();

        // 2. FIXED: Keeps your dynamic polymorphic subclasses intact
        accounts.add(new SavingsAccount("Kunal", 1234, 1000.0, 5.0));
        accounts.add(new CurrentAccount("Kunal", 5678, 5000.0, 1000.0)); 

        // 3. FIXED: Using bankAccountSystem reference for loop iteration
        for (bankAccountSystem acc : accounts) {
            System.out.println("----------------------------------------");
            
            acc.displayAccountDetails(); 
            acc.withdraw(400);
            acc.displayAccountDetails();
        }
        System.out.println("----------------------------------------");
    } // Closes main
}