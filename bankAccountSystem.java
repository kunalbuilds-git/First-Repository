//setting class named account 
public class bankAccountSystem{
    //setting the fields private
    private String accountHolderName;
    private int accountNumber;
    private double balance;

    //Constructor to initialize all fields
    bankAccountSystem(String name, int accountNo, double accountbalance){
        this.accountHolderName = name;
        this.accountNumber = accountNo;
        if(accountbalance >= 0) {
            this.balance = accountbalance;
        }
        else{
            System.out.println("Invalid balance ammount!! Defaulting the balance to $0.0");
            this.balance = 0.0;
        }
    }
    void deposit(double amount){
        if(amount >= 0 ) {
            this.balance = this.balance + amount;
            System.out.println("Amount deposited successfully: $" + amount);
        }
        else{
            System.out.println("Rejected!! You cannot deposite negative or zero amount.");
        }        
    }

    void withdraw(double amount){
        if(amount <= 0) {
            System.out.println("Rejected!! You cannot withdraw negative or zero amount of money.");
        }
        else if (amount <= balance) {
            this.balance = this.balance - amount;
            System.out.println("Amount withdrew Successfully: $" + amount);
        }
        else{
            System.out.println("Transaction denied! Insufficient funds for withdrawal.");
        }           
    }

    void displayBalance(){
        System.out.println("Your Current account balance is: $" + this.balance);
    }

    //getter for account holder name
    public String getaccountHolderName(){
        return this.accountHolderName;
    }

    //getter for balance
    public double getBalance() {
        return this.balance;
    }

    public static void main(String[] args){
        bankAccountSystem savingsAccount = new bankAccountSystem ("Kunal", 12345, 10009.00);
        savingsAccount.displayBalance();

        savingsAccount.deposit(2000000.00);
        savingsAccount.withdraw(2345.98);
        savingsAccount.displayBalance();

        bankAccountSystem currentAccount = new bankAccountSystem("Rahul", 678901, 200.00);
        currentAccount.displayBalance();

        currentAccount.withdraw(201);
        
        currentAccount.withdraw(-999);
        currentAccount.deposit(0);
    }
}