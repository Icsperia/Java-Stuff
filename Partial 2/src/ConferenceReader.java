import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ConferenceReader {
    public static ArrayList<Conference> readConference(String filePath) {
        ArrayList<Conference> conferences = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // skip header
            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");
                Conference conference = new Conference(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        data[3],
                        data[4],
                        Integer.parseInt(data[5]),
                        Integer.parseInt(data[6]),
                        Double.parseDouble(data[7]),
                        data[8]
                );
                System.out.println("Conference Details: " + conference);
                if (conference.getMaxParticipants() > (conference.getAvailableRooms() * 10)) {
                    System.out.println("Adding conference to the list.");
                    conferences.add(conference);
                } else {
                    System.out.println("Excluding conference from the list.");
                }
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        return conferences;
    }
}
