public class bankAccountSystem {
    // 1. Setting the fields private
    private String accountHolderName;
    private int accountNumber;
    private double balance;
    private String accountType; 

    // 2. [UPDATE] Constructor to initialize all fields including accountType
    bankAccountSystem(String name, int accountNo, double accountbalance, String type) {
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
        if (amount > 0) { // Changed from >= 0 to make zero deposits invalid as per your main test
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
        // Testing with the new accountType parameter
        bankAccountSystem savingsAccount = new bankAccountSystem("Kunal", 12345, 10009.00, "Savings");
        savingsAccount.displayAccountDetails();

        savingsAccount.deposit(20000.00);
        savingsAccount.withdraw(2345.98);
        savingsAccount.displayAccountDetails();

        bankAccountSystem currentAccount = new bankAccountSystem("Rahul", 678901, 200.00, "Current");
        currentAccount.displayAccountDetails();

        // Testing error validations
        currentAccount.withdraw(201);
        currentAccount.withdraw(-999);
        currentAccount.deposit(0);
    }
}