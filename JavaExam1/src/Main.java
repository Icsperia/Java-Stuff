import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Collections;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String filePath = ("D:\\Documents\\JavaExam1\\festivals.csv");
        ArrayList<Festival> fl = Festival.FestivalReader(filePath);
        Festival festival = new Festival();
        ArrayList<Festival> nrock = festival.getRock();
        ArrayList<Festival> norock = festival.getNonrock();

        festival.RockGenre(fl);
        System.out.println("Prima citire");
        for (Festival festival1 : fl) {
            System.out.println(festival1);
        }
        System.out.println();
        System.out.println("Rock");
        for (Festival festival1 : nrock) {
            System.out.println(festival1);

        }
        System.out.println();
        System.out.println("NoRock");
        for (Festival festival1 : norock) {
            System.out.println(festival1);

        }
        ArrayList<Festival> flCopy = new ArrayList<>(fl);  // Create a copy before sorting
        Collections.sort(flCopy, new Sorter());

        System.out.println();
        System.out.println("Lista Sortata");
        for (Festival festival1 : flCopy) {
            System.out.println(festival1);
        }
        ArrayList<Festival> flCopy1 = new ArrayList<>(fl);
        FestivalThread t = new FestivalThread(fl, filePath);
        Thread t1 = new Thread(t);
        ArrayList Festival=t.Festival;
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Lista pe fir de executie");
        for (Festival games : flCopy1 ) {
            System.out.println(games);
        }


    }
}