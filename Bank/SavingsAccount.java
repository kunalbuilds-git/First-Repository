package Bank;
//creating another class/file for accounts - savings and Current
public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountHolderName, int accountNumber, double balance, double interestRate) {
        super(accountHolderName, accountNumber, balance);
        this.interestRate = interestRate;
    }
    //making METHOD for savings account
    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Account Type: Saving ");
        System.out.println(" Interest Rate: " + this.interestRate + "%");
        System.out.println("==============================================================");
    }

    //adding the Interest method
    public void addInterest() {
        double interest = balance * (interestRate/100);
        super.deposit(interest);
        System.out.println("Interest added on your savings account balance: " + interest);
    }
}

