//setting class named account 
class Account{
    String accountHolderName;
    int accountNumber;
    double balance;

    //Constructor to initialize all fields
    Account(String name, int accountNo, double accountbalance){
        this.accountHolderName = name;
        this.accountNumber = accountNo;
        this.balance = accountbalance;
    }

    void deposit(double amount){
        this.balance = this.balance + amount;
        System.out.println("Amount deposited successfully: $" + amount);
    }

    void withdraw(double amount){
        if (amount <= balance){
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

    public static void main(String[] args){
        Account savingsAccount = new Account ("Kunal", 12345, 10009.00);
        savingsAccount.displayBalance();

        savingsAccount.deposit(2000000.00);
        savingsAccount.withdraw(2345.98);
        savingsAccount.displayBalance();

        Account currentAccount = new Account("Rahul", 678901, 200.00);
        currentAccount.displayBalance();

        currentAccount.withdraw(201);

        
    }
}