package Bank;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner; // Step 1: Imported the utility framework

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

        // Declare a resizable ArrayList that manages references of type 'Account'
        ArrayList<Account> accounts = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        while(true) {
            try {
                System.out.println("\n---MAIN MENU---");
                System.out.println("1. Create New Account");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Display All Accounts");
                System.out.println("5. Exit System");
                System.out.println("Enter Your Choice (1-5): ");

                int choice = sc.nextInt();
                sc.nextLine(); //Clears enter key from the stream

                if(choice == 5){
                    System.out.println("Exiting System.... Goodbye!");
                    break;
                }

                switch(choice){
                    case 1:
                        System.out.println("Enter Account Holder's Name: ");
                        String name = sc.nextLine();

                        System.out.println("Enter Your Unique Account Number: ");
                        int accNum = sc.nextInt();

                        System.out.println("Enter Initial Deposite Balance: ");
                        Double initBalance = sc.nextDouble();
                        sc.nextLine();

                        //Instantiates and saves it inside your dynamic list!
                        accounts.add(new Account(name, accNum, initBalance));
                        System.out.println("Account opened and initial amount added Successfully!");
                        break;

                    case 2:
                        System.out.println("Enter the target Account Number for Deposit: ");
                        int depositaccNum = sc.nextInt();

                        System.out.print("Enter the amount to deposit: ");
                        double depositAmt = sc.nextDouble();
                        sc.nextLine(); //buffer clearing 

                        Boolean depFound = false;

                        // Loop through the dynamic list created 
                        for (Account acc : accounts) {
                            if (acc.accountNumber == depositaccNum) {
                                try {
                                    acc.deposit(depositAmt);
                                } catch (IllegalArgumentException e) {
                                    System.out.println("Error: " + e.getMessage());
                                }
                                depFound = true;
                                break; 
                            }
                        }
                        
                        if (!depFound) {
                            System.out.println("Error: Account Number " + depositaccNum + " not found.");
                        }
                        break;

                    case 3:
                        System.out.println("Enter the target Account Number for withdrawal: ");
                        int withdrawalaccNum = sc.nextInt();

                        System.out.print("Enter the amount to withdraw: ");
                        double withdrawalAmt = sc.nextDouble();
                        sc.nextLine(); 

                        Boolean witFound = false;

                        // Loop through your list to find a structural field match
                        for (Account acc : accounts) {
                            if (acc.accountNumber == withdrawalaccNum) {
                                try {
                                    acc.withdraw(withdrawalAmt);
                                } catch (IllegalArgumentException e) {
                                    System.out.println("Error: " + e.getMessage());
                                }
                                witFound = true;
                                break; 
                            }
                        }
                        
                        if (!witFound) {
                            System.out.println("Error: Account Number " + withdrawalaccNum + " not found.");
                        }
                        break;

                    case 4:
                        if(accounts.isEmpty()){
                            System.out.println("There is nothing in our inventory! No active accounts found.");
                        }else{
                            System.out.println("\n--PRINTING ALL THE ACCOUNTS---");
                            for (Account acc: accounts) {
                                acc.displayAccountDetails();
                            }
                        }
                        break;


                    default:
                        System.out.print("Invalid Option!! Please choose a option between 1 to 5.");

                }
            }

            catch(InputMismatchException e){
                System.out.println("ERROR: Invalid input type! Please enter numbers only.");
                sc.nextLine(); //avoiding infite loop 
            }
        }
        sc.close();        
    }
}