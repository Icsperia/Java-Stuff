import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
      String filepath="D:\\Documents\\JavaExam2\\Examen.csv";
        ArrayList<Examen> Ex= Examen.ExamenReader(filepath);

    for(Examen examen:Ex){
        System.out.println(examen);
    }
        Collections.sort(Ex);
  System.out.println();
    System.out.println("Lista sortata");
    for(Examen examen :Ex){
        System.out.println(examen);
    }
ArrayList<Examen> ex1=new ArrayList<>(Ex);
  ExamenThread t = new ExamenThread(ex1,filepath);
        Thread t1= new Thread(t);
        ArrayList VideoGames =t.Examen;
        t.start();
        try{
            t.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Lista pe fir de executie");
        for(Examen games : Ex ){
            System.out.println(games);
        }



        String output="Examen1.csv";
        ArrayList<Examen> exmas= Examen.ExamenReader(filepath);
        Examen.WriteToExams(output, exmas);

        System.out.println("From Exam1");
   for(Examen ex:exmas){
       System.out.println(ex);
   }

        HashMap<String, ArrayList<Examen>> groupedConferences = new HashMap<>();
        for (Examen conference :Ex ) {
            String examen= conference.getEXAMEN();
            if (!groupedConferences.containsKey(examen)) {
                groupedConferences.put(examen, new ArrayList<>());
            }
            groupedConferences.get(examen).add(conference);
        }


        System.out.println("\nExamen grupate dupa STATUS si sortate dupa taxa de inscriere:");
        for (String examen : groupedConferences.keySet()) {
            System.out.println("Examn cu statusul '" + examen + "':");


            ArrayList<Examen> conferencesByStatus = groupedConferences.get(examen);
            Collections.sort(conferencesByStatus);

            for (Examen conference : conferencesByStatus) {
                System.out.println(conference);
            }
            System.out.println();
        }
    }


}
