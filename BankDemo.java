import java.util.Scanner;

// Base class
class Account {
    String name;
    int accNo;
    String accType;
    double balance;

    void deposit(double amt) {
        balance += amt;
        System.out.println("Amount deposited successfully.");
    }

    void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

// Savings Account
class SavAcct extends Account {

    double rate = 0.05; // 5% interest

    SavAcct(String n, int a, double b) {
        name = n;
        accNo = a;
        accType = "Savings";
        balance = b;
    }

    void computeInterest() {
        double interest = balance * rate;
        balance += interest;
        System.out.println("Interest added: " + interest);
    }

    void withdraw(double amt) {
        if (amt <= balance) {
            balance -= amt;
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

// Current Account
class CurAcct extends Account {

    double minBalance = 1000;
    double penalty = 100;

    CurAcct(String n, int a, double b) {
        name = n;
        accNo = a;
        accType = "Current";
        balance = b;
    }

    void withdraw(double amt) {
        if (amt <= balance) {
            balance -= amt;
            if (balance < minBalance) {
                balance -= penalty;
                System.out.println("Minimum balance not maintained.");
                System.out.println("Penalty imposed: " + penalty);
            }
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

// Main class
public class BankDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();

        System.out.print("Enter initial balance: ");
        double bal = sc.nextDouble();

        if (choice == 1) {
            SavAcct s = new SavAcct(name, accNo, bal);
            s.deposit(2000);
            s.computeInterest();
            s.withdraw(1500);
            s.displayBalance();
        } 
        else if (choice == 2) {
            CurAcct c = new CurAcct(name, accNo, bal);
            c.deposit(3000);
            c.withdraw(4500);
            c.displayBalance();
        } 
        else {
            System.out.println("Invalid choice.");
        }

        sc.close();
    }
}
