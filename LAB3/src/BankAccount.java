import java.util.ArrayList;
import java.util.Currency;

public class BankAccount extends Account {
ArrayList<Integer> acc =new ArrayList<>();
public BankAccount(double accountNumber,double balance,String OwnerName,String Currency){super(accountNumber,balance,OwnerName,Currency);
this.acc=new ArrayList<>();
}

    public BankAccount() {
        super();
    }

    public void printStatement(){
    System.out.println("Transaction History");
for(Integer transaction:acc){
    System.out.println(acc);
}
}


public void Deposit(int amount){
    super.Deposit(amount);
    acc.add(amount);

}
public void Withdraw(int amount) throws InsufficientFundsException{
    super.Deposit(amount);
    acc.add(-amount);
}
}
