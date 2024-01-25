import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        ArrayList<VideoGames> Vgs =new ArrayList<>();
        String filePath=("D:\\Documents\\Partial\\Game.csv");
        VideoGameThread t = new VideoGameThread(Vgs,filePath);
      Thread t1= new Thread(t);
      ArrayList VideoGames =t.VideoGames;

      t1.start();
        try{
            t1.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Lista pe fir de executie");
        for(VideoGames games : Vgs ){
            System.out.println(games);
        }

        t.start();
 try{
     t.join();
 }catch(InterruptedException e){
     e.printStackTrace();
 }

 System.out.println();
 System.out.println("Lista pe fir de executie");
 for(VideoGames gv:Vgs){
    System.out.println(gv);
}
    }


}