import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;

public class VideoGames implements Comparator<VideoGames> {

    int GAME_ID;
    String TITLE;
    String DEVELOPER;
    String GENRE;
    double RELEASE_YEAR;
    String PLATFORMS;
    double PRICE;
    double RATING;
    int PLAYTIME;

    public VideoGames(int GAME_ID, String TITLE, String DEVELOPER, String GENRE, Double RELEASE_YEAR, String PLATFORMS, double PRICE, double RATING, int PLAYTIME) {
        this.GAME_ID = GAME_ID;
        this.TITLE = TITLE;
        this.DEVELOPER = DEVELOPER;
        this.GENRE = GENRE;
        this.RELEASE_YEAR = RELEASE_YEAR;
        this.PLATFORMS = PLATFORMS;
        this.PRICE = PRICE;
        this.RATING = RATING; // Convert double to int if needed
        this.PLAYTIME = PLAYTIME;
    }

    public VideoGames() {

    }
    public static double ParseString(String priceString){

        if(priceString.equalsIgnoreCase("Free")){
            return 0.0;
        }else
            return Double.parseDouble(priceString);

    }



    public static ArrayList<VideoGames> readGames(String filePath){
        ArrayList<VideoGames> VideoGames=new ArrayList<>();

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



        return VideoGames;
    }




    @Override
    public String toString() {
        return "VideoGames{" + "GAME_ID=" + GAME_ID + ", TITLE='" + TITLE + '\'' + ", DEVELOPER='" + DEVELOPER + '\'' + ", GENRE='" + GENRE + '\'' + ", RELEASE_YEAR=" + RELEASE_YEAR + ", PLATFORMS='" + PLATFORMS + '\'' + ", PRICE=" + PRICE + ", RATING=" + RATING + ", PLAYTIME=" + PLAYTIME + '}';
    }

    @Override
    public int compare(VideoGames o1, VideoGames o2) {


      return Double.compare(o1.RELEASE_YEAR,o2.RELEASE_YEAR);

    }


    public int getGAME_ID() {
        return GAME_ID;
    }

    public void setGAME_ID(int GAME_ID) {
        this.GAME_ID = GAME_ID;
    }
}