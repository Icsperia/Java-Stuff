import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String filePath="D:\\Documents\\Lab Final\\ conferences.csv";
        ArrayList<Conference> conferences=ConferenceReader.readConference(filePath);
System.out.println("Afisare lista");
for(Conference conference:conferences){
    System.out.println(conference.toString());
}

        Collections.sort(conferences, new SorterByTax());
System.out.println();
System.out.println("Lista sortata");
for(Conference conference:conferences){
    System.out.println(conference);
}
        HashMap<String, ArrayList<Conference>> groupedConferences = new HashMap<>();
        for (Conference conference : conferences) {
            String status = conference.getStatus();
            if (!groupedConferences.containsKey(status)) {
                groupedConferences.put(status, new ArrayList<>());
            }
            groupedConferences.get(status).add(conference);
        }


        System.out.println("\nConferinte grupate dupa STATUS si sortate dupa taxa de inscriere:");
        for (String status : groupedConferences.keySet()) {
            System.out.println("Conferintele cu statusul '" + status + "':");


            ArrayList<Conference> conferencesByStatus = groupedConferences.get(status);
            Collections.sort(conferencesByStatus, new SorterByTax());

            for (Conference conference : conferencesByStatus) {
                System.out.println(conference);
            }
            System.out.println();
        }
   }
   }





