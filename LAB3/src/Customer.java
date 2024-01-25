import java.lang.reflect.Array;
import java.util.ArrayList;

public class Customer {
String name;
ArrayList<Account> accounts;
public Customer(String name,ArrayList<Account>accounts){
    this.name=name;
accounts=new ArrayList<>();

}
public Customer(){

}
public void addAccount(Account account){

accounts.add(account);

}
public void Remove(Account account){
    accounts.remove(account);
}
public void getAccountInfo(){
    for(Account account : accounts){
        System.out.println("Account number" +account.getAccountNumber());
System.out.println("Balance"+account.getBalance());

    }

}
    public ArrayList<Account> getAccounts() {
        return accounts;
    }
    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }
}
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }


}
