import java.util.ArrayList;
import java.util.Collections;

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
    }
}