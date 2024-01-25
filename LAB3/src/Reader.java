import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Reader extends Thread {

    Account acc;
    String csvFilePath;


    public void run(){

        ArrayList<Account> acc=new ArrayList<>();

        try{
            File f = new File(csvFilePath);
            BufferedReader br =new BufferedReader(new FileReader(f));
            String line;
            while((line=br.readLine())!=null){

                String[] data =line.split(",");

                int accountNumber=Integer.parseInt(data[0]);
                double balance=Double.parseDouble(data[1]);
                String ownerName=data[2];
                String currency=data[3];
                Account acc1=new Account(accountNumber,balance,ownerName,currency);


            }


        }catch(Exception e){
            System.out.println(e);

        }








    }








}

