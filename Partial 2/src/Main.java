import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String filePath = "D:\\Documents\\Partial 2\\ conferences.csv";
        ArrayList<Conference> conferences = ConferenceReader.readConference(filePath);

        // Sort conferences using SortByTax comparator
        Collections.sort(conferences, new SortByTax());

        // Display the sorted list of conferences
        System.out.println("Lista de conferinte sortate dupa taxa de inscriere:");
        for (Conference conference : conferences) {
            System.out.println(conference);
        }

        // Group conferences by status and sort within each group by registration fee
        HashMap<String, ArrayList<Conference>> groupedConferences = new HashMap<>();
        for (Conference conference : conferences) {
            String status = conference.getStatus();
            if (!groupedConferences.containsKey(status)) {
                groupedConferences.put(status, new ArrayList<>());
            }
            groupedConferences.get(status).add(conference);
        }

        // Display grouped conferences by status and sorted within each group by registration fee
        System.out.println("\nConferinte grupate dupa STATUS si sortate dupa taxa de inscriere:");
        for (String status : groupedConferences.keySet()) {
            System.out.println("Conferintele cu statusul '" + status + "':");

            // Sort conferences within each group using SortByTax comparator
            ArrayList<Conference> conferencesByStatus = groupedConferences.get(status);
            Collections.sort(conferencesByStatus, new SortByTax());

            for (Conference conference : conferencesByStatus) {
                System.out.println(conference);
            }
            System.out.println();
        }

        System.out.println("\nProgramul a rulat cu succes!");
        System.out.println("Number of conferences read: " + conferences.size());
    }

}