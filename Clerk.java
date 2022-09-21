import java.util.Random;
import java.util.Scanner;

class Account {
    long account_number;
    double amount;
    int age;
    int withdraw, deposit;
    String name;
    Scanner scn = new Scanner(System.in);

    public Account() {
        Random rand = new Random();// random method for taking random int
        this.amount = 0.00;
        // taking 10-digit account number
        this.account_number = 1000000000 + rand.nextInt(999999999);
        this.withdraw = 0;
        this.deposit = 0;
    }

    // Method to create the customer's account
    void createAccount() {

        System.out.println("Enter the name of the customer");
        this.name = scn.nextLine();
        System.out.println("Enter the age of the customer");
        this.age = scn.nextInt();

        System.out.println("Account created SUCCESSFULLY");
        return;
    }

    // Method to display customer's details
    void displayDetails() {
        System.out.println("Customer name :" + this.name);
        System.out.println("Customer age:" + this.age);
        System.out.println("Account number:" + this.account_number);
        System.out.println("Last deposit:" + this.deposit);
        System.out.println("Last withdrawal:" + this.withdraw);
        return;

    }

    // Method to withdraw money
    void withdrawMoney() {

        System.out.println("Enter amount to withdraw:");
        this.withdraw = scn.nextInt();
        this.amount = this.amount - this.withdraw;
        System.out.println("Amount withdrawal SUCCESSFUL");
        System.out.println("Amount:" + this.amount);
        return;
    }

    // Method to deposit money
    void depositMoney() {

        System.out.println("Enter amount to deposit:");
        this.deposit = scn.nextInt();
        this.amount = this.amount + this.deposit;
        System.out.println("Amount deposit SUCCESSFUL");
        System.out.println("Amount:" + this.amount);
        return;
    }
}

class Clerk {
    // main class
    public static void main(String[] args) {
        Account[] customer;// customer array
        customer = new Account[10];
        int n = 0, m = -1;
        char ch = 'n';
        Scanner scn = new Scanner(System.in);
        do {
            long account;
            System.out.println("Enter your choice \n1) Withdraw Money\n2)Create account");
            System.out.println("3)Deposit money\n4)Know account details\n0) Exit");
            m = scn.nextInt();
            switch (m) {

                case 1:
                    // to withdraw money
                    System.out.println("Enter account number to withdraw money");
                    account = scn.nextLong();
                    for (int j = 0; j < n; j++) {
                        if (customer[j].account_number == account) {
                            customer[j].withdrawMoney();
                            customer[j].displayDetails();// method calling
                            break;
                        } else if (j == 0) {
                            System.out.println("Invalid account number");
                        }
                    }
                    break;
                case 2:
                    // to create account
                    customer[n] = new Account();// default constructor
                    customer[n].createAccount();// method calling
                    customer[n].displayDetails();// method calling
                    n++;
                    break;
                case 3:
                    // to deposit money
                    System.out.println("Enter account number to withdraw money");
                    account = scn.nextLong();
                    for (int j = 0; j < n; j++) {
                        if (customer[j].account_number == account) {
                            customer[j].depositMoney();
                            customer[j].displayDetails();// method calling
                            break;
                        } else if (j == n) {
                            System.out.println("Invalid account number");
                        }
                    }
                    break;
                case 4:
                    // to know account details
                    System.out.println("Enter account number to know account details");
                    account = scn.nextLong();
                    for (int j = 0; j < n; j++) {
                        if (customer[j].account_number == account) {
                            customer[j].displayDetails();// method calling
                            break;
                        } else if (j == n) {
                            System.out.println("Invalid account number");
                        }
                    }
                    break;
                default:
                    break;

            }

            System.out.println("Do you want to continue (y or n)");
            ch = scn.next().charAt(0);
            n++;
        } while (n < 10 && (ch == 'Y' || ch == 'y'));
        scn.close();
    }
}
