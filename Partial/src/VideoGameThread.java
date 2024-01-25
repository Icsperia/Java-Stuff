import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class VideoGameThread extends Thread {
ArrayList<VideoGames> VideoGames;
String filePath;
    public VideoGameThread(ArrayList<VideoGames> videoGames,String filePath) {
        this.VideoGames = videoGames;
    this.filePath=filePath;
    }


    @Override
    public void run() {


        try(BufferedReader br =new BufferedReader(new FileReader(filePath))){
            String line;
            br.readLine();
            while((line=br.readLine())!=null){
                String[] data = line.split(",");
                VideoGames Vg =new VideoGames(
                        Integer.parseInt(data[0]),
                        data[1].trim(),
                        data[2].trim(),
                        data[3].trim(),
                        Double.parseDouble(data[4]),
                        data[5],
                        ParseString(data[6]),
                        Double.parseDouble(data[7]),
                        Integer.parseInt(data[8])

                );


                VideoGames.add(Vg);
            }






        }catch (IOException e) {
            e.printStackTrace();
        }




    }


    public static double ParseString(String priceString){

        if(priceString.equalsIgnoreCase("Free")){
            return 0.0;
        }else
            return Double.parseDouble(priceString);

    }


}