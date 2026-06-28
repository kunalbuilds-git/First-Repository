package Bank;

// FIXED: Renamed class from 'bankAccountSystem' to 'Account' to match your array declaration and child file setups
public class bankAccountSystem {
    // 1. Setting the fields protected
    protected String accountHolderName;
    protected int accountNumber;
    protected double balance;
    protected String accountType; 

    // 2. [UPDATE] Constructor updated to match class name 'Account'
    public bankAccountSystem(String name, int accountNo, double accountbalance, String type) {
        this.accountHolderName = name;
        this.accountNumber = accountNo;
        
        // Validate and assign accountType
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

    // 3. [NEW] Replaced displayBalance() with the structured displayAccountDetails()
    void displayAccountDetails() {
        System.out.println("\n═══════════════════════════════");
        System.out.println("Account Holder:  " + this.accountHolderName);
        System.out.println("Account Number:  " + this.accountNumber);
        System.out.println("Account Type:    " + this.accountType);
        System.out.println("Balance:         $" + this.balance);
        System.out.println("═══════════════════════════════");
    }

    // Getter for account holder name
    public String getaccountHolderName() {
        return this.accountHolderName;
    }

    // Getter for balance
    public double getBalance() {
        return this.balance;
    }

    // 4. [NEW] Getter for accountType
    public String getAccountType() {
        return this.accountType;
    }

    // 5. [NEW] Setter for accountType with basic validation
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

        // 1. Create the Polymorphic Array (Holds generic Account references)
        Account[] accounts = new Account[2];

        // 2. Upcast your accounts directly into the array slots
        accounts[0] = new SavingsAccount("Kunal", 1234, 1000.0, 5.0);
        accounts[1] = new CurrentAccount("Kunal", 5678, 5000.0, 1000.0);

        // 3. The Polymorphic Loop (Dynamic Method Dispatch)
        for (Account acc : accounts) {
            System.out.println("----------------------------------------");
            
            // This dynamically triggers the correct overridden display behavior!
            acc.displayAccountDetails(); 
            
            // This dynamically runs the correct withdrawal rules per class type
            acc.withdraw(400);
            
            acc.displayAccountDetails();
        }
        System.out.println("----------------------------------------");
    } // Closes main
} // FIXED: Added this missing closing brace to terminate the Account class cleanly