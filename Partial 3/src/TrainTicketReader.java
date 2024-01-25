import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class TrainTicketReader {
    public static ArrayList<Ticket> readTrainTickets(String filePath) {
        ArrayList<Ticket> trainTickets = new ArrayList();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String ruta = data[1];
                String statiePlecare = data[2];
                String statieSosire = data[3];
                String oraPlecare = data[4];
                String oraSosire = data[5];
                int clasa = Integer.parseInt(data[6]);
                String tipBilet = data[7];
                double pret = Double.parseDouble(data[8]);
                String status = data[9];

                if (isValidTime(oraPlecare, oraSosire)) {
                    Ticket ticket = new Ticket(id, ruta, statiePlecare, statieSosire, oraPlecare, oraSosire, clasa,tipBilet,pret, status);
                    trainTickets.add(ticket);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return trainTickets;
    }

public static boolean isValidTime(String oraPlecare,String oraSosire){
        String[] P=oraPlecare.split(":");
        String[] S=oraSosire.split(":");
        int oP=Integer.parseInt(P[0]);
        int mP=Integer.parseInt(P[1]);

        int oS=Integer.parseInt(S[0]);
        int mS=Integer.parseInt(S[1]);
        return (oS>oP)||(oS==oP);
}
}
