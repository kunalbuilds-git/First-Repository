package Bank;

//separate class for Current Account
public class CurrentAccount extends Account {
    private double overdraftLimit;

    //Constructor taking 4 same arguments from the parent class 
    public CurrentAccount(String accountHolderName, int accountNumber, double balance, double overdraftLimit) {
        super(accountHolderName, accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }
    
    //Creating method to Current Account Details
    @Override
    public void displayAccountDetails(){
        super.displayAccountDetails();
        System.out.println("Account Type: Current Account.");
        System.out.println("Your overdraft limit is: $" + this.overdraftLimit);
        System.out.println("===================================================");
    }

    //Creating method for withdrawing money
    @Override
    public void withdraw(double amount){
        if(amount <= 0){
            System.out.println("Rejected! You cannot withdraw negative or zero amount of money.");
        }
        else if( amount <= (balance + overdraftLimit)) {
            this.balance = this.balance - amount;
            System.out.println("Amount withdrawn Successfully: $" + amount);
        }
        else{
            System.out.println("Transaction denied! Overdraft limit exceeded.");
        }
    }
}
