import java.util.ArrayList;
import java.util.Scanner;

public class Account {
double accountNumber;
double balance;
String ownerName;
String currency;
ArrayList<Account> acc = new ArrayList<>();
public Account(double accountNumber,double balance,String ownerName,String currency){
    this.accountNumber=accountNumber;
    this.balance=balance;
    this.ownerName=ownerName;
    this.currency=currency;
}

    public Account() {

    }

    public double getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(double accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
public void Deposit(double input){


System.out.println("Amount to deposit");
balance=input+balance;

System.out.println("Amount"+balance);


}
public void  Withdraw(double amount) throws InsufficientFundsException {

    System.out.println("Amount to withdraw");
    if (amount > balance) {
        throw new InsufficientFundsException("Insufficient funds");
    }
    balance -= amount;
        System.out.println("Amount" + balance);
    }

public void Transfer(Account destination,double amount) throws InsufficientFundsException{
Withdraw(amount);
destination.Deposit(amount);
    System.out.println("Transfer successful. Current balance: " + balance);

}
    public void printStatement(){
        System.out.println("Transaction History");
        for(Account transaction:acc){
            System.out.println(acc);
        }
    }


}
