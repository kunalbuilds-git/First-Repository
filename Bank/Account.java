package Bank;
import java.util.ArrayList; // Step 1: Imported the utility framework

public class Account implements Transaction {
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
            throw new IllegalArgumentException("Initial balance cannot be negative!");
        }
    }

    // Standard deposit method
    public void deposit(double amount) {
        if (amount > 0) { 
            this.balance = this.balance + amount;
            System.out.println("Amount deposited successfully: $" + amount);
        } else {
           throw new IllegalArgumentException("Deposit amount must be greater than zero");
        }        
    }

    // Standard withdraw method
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("withdrawal amount must be greater than zero!");
        } else if (amount <= balance) {
            this.balance = this.balance - amount;
            System.out.println("Amount withdrew Successfully: $" + amount);
        } else {
            throw new IllegalArgumentException("Insufficient amount for this withdrawal!");
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

    //DAY 70: DYNAMIC ARRAYLIST IMPLEMENTATION
    public static void main(String[] args) {
        System.out.println("--- BANKING SYSTEM POLYMORPHIC ARRAYLIST --- \n");

        // 1. Declare a resizable ArrayList that manages references of type 'Account'
        ArrayList<Account> accounts = new ArrayList<>();

        // 2. Dynamically add your subclass objects to the list
        accounts.add(new SavingsAccount("Kunal - Savings", 1234, 1000.0, 5.0));
        accounts.add(new CurrentAccount("Kunal - Current", 5678, 5000.0, 1000.0)); 

        // 3. Loop through dynamic list
        for (Account acc : accounts) {
            System.out.println("----------------------------------------");
            
            // Triggers overridden method behaviors dynamically
            acc.displayAccountDetails(); 
            
            try {
                acc.withdraw(400);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
            
            acc.displayAccountDetails();
        }
        System.out.println("----------------------------------------");
    }
}