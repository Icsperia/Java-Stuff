import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer();
        OperationReader op = new OperationReader();
      SavingsAccount sa=new SavingsAccount();
        op.setCsvFilePath("bank.csv");
        op.start();
        try {
            op.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ArrayList<Account> accounts = op.getAccounts();
        customer.setAccounts(accounts);

        int choice;
        do {
            System.out.println("1. Deposit\n2. Withdraw\n3. Transfer\n4. Print Statement\n5. Update Savings Account\n6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    performDeposit(scanner, customer);
                    break;
                case 2:
                    performWithdraw(scanner, customer);
                    break;
                case 3:
                    performTransfer(scanner, customer);
                    break;
                case 4:
                    performPrintStatement(customer);
                    break;
                case 5:
                    performUpdateInterest(scanner, customer,sa);
                    break;
                case 6:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        scanner.close();
        for (Account acc : accounts) {
            System.out.println("Account: " + acc.getAccountNumber() + ", " + acc.getOwnerName() + ", " + acc.getCurrency());
        }
    }

   public  static void performDeposit(Scanner scanner, Customer customer) {
        System.out.print("Enter amount to deposit: ");
        double depositAmount = scanner.nextDouble();

        // Consume the newline character left in the input buffer
        scanner.nextLine();

        System.out.print("Enter account number: ");
       int  accountNumber = scanner.nextInt();

        Account account = findAccount(customer,  accountNumber);
        if (account != null) {
            account.Deposit(depositAmount);
        } else {
            System.out.println("Account not found.");
        }
    }


  public static void performWithdraw(Scanner scanner, Customer customer) {
        try {
            System.out.print("Enter amount to withdraw: ");
            double withdrawAmount = scanner.nextDouble();
            System.out.print("Enter account number: ");
            int accountNumber = scanner.nextInt();

            Account account = findAccount(customer, accountNumber);
            if (account != null) {
                account.Withdraw(withdrawAmount);
            } else {
                System.out.println("Account not found.");
            }
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void performTransfer(Scanner scanner, Customer customer) {
        try {
            System.out.print("Enter source account number: ");
            int sourceAccountNumber = scanner.nextInt();
            System.out.print("Enter destination account number: ");
            int destinationAccountNumber = scanner.nextInt();
            System.out.print("Enter amount to transfer: ");
            double transferAmount = scanner.nextDouble();

            Account sourceAccount = findAccount(customer, sourceAccountNumber);
            Account destinationAccount = findAccount(customer, destinationAccountNumber);

            if (sourceAccount != null && destinationAccount != null) {
                sourceAccount.Transfer(destinationAccount, transferAmount);
            } else {
                System.out.println("Source or destination account not found.");
            }
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

 public static void performPrintStatement(Customer customer) {
        for (Account account : customer.getAccounts()) {
            account.printStatement();
        }
    }

    public static void performUpdateInterest(Scanner scanner, Customer customer ,SavingsAccount sa) {
        System.out.print("Enter amount to deposit: ");
        double depositAmount = scanner.nextDouble();
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();

        System.out.println("Enter interest rate: ");
        double interestRate = scanner.nextDouble();
        scanner.nextLine();

        for (Account account : customer.getAccounts()) {
            if (account instanceof SavingsAccount) {
                ((SavingsAccount) account).updateInterest();
            }


        }
    System.out.println(""+depositAmount+","+accountNumber+","+interestRate);
    }

    public static Account findAccount(Customer customer, int accountNumber) {
        for (Account account : customer.getAccounts()) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

}




