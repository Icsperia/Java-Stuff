import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class OperationReader extends Thread {

    private String csvFilePath;
    private ArrayList<Account> accounts = new ArrayList<>();

    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader(new File(csvFilePath)))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                double accountNumber = Double.parseDouble(data[0]);
                double balance = Double.parseDouble(data[1]);
                String ownerName = data[2];
                String currency = data[4];
                String accountType = data[3];

                Account acc1;
                if ("bank".equalsIgnoreCase(accountType)) {
                    acc1 = new BankAccount(accountNumber, balance, ownerName, currency);
                } else if ("savings".equalsIgnoreCase(accountType)) {
                    acc1 = new SavingsAccount();
                } else {
                    // Handle unknown account types
                    System.out.println("Unknown account type: " + accountType);
                    continue;  // Skip to the next line
                }

                accounts.add(acc1);
            }
        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing CSV data: " + e.getMessage());
        }

    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setCsvFilePath(String csvFilePath) {
        this.csvFilePath = csvFilePath;
    }
}
