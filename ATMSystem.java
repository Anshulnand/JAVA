import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        } else {
            balance -= amount;
            return true;
        }
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void withdraw(double amount) {
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. New balance: " + account.getBalance());
        } else {
            System.out.println("Insufficient balance. Withdrawal failed.");
        }
    }

    public void deposit(double amount) {
        account.deposit(amount);
        System.out.println("Deposit successful. New balance: " + account.getBalance());
    }

    public void checkBalance() {
        System.out.println("Your current balance is: " + account.getBalance());
    }
}

public class ATMSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BankAccount account = new BankAccount(1000); // Initial balance is 1000
        ATM atm = new ATM(account);

        int choice;
        do {
            System.out.println("\n=== ATM Menu ===");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Please choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (withdrawAmount <= 0) {
                        System.out.println("Please enter a valid positive amount.");
                    } else {
                        atm.withdraw(withdrawAmount);
                    }
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    if (depositAmount <= 0) {
                        System.out.println("Please enter a valid positive amount.");
                    } else {
                        atm.deposit(depositAmount);
                    }
                    break;

                case 3:
                    atm.checkBalance();
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
