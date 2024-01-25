public class SavingsAccount extends Account{
    double interest_rate;

    public SavingsAccount(double accountNumber,double balance,String ownerName,String currency,double interest_rate) {super(accountNumber,balance,ownerName,currency);

this.interest_rate=interest_rate;
    }

    public SavingsAccount() {

    }

    public void updateInterest(){

double interestAmount=interest_rate*getBalance()/100;
Deposit(interestAmount);
System.out.println("New Balance"+getBalance());

}


}
