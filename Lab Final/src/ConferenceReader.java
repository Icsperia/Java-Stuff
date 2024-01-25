

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class ConferenceReader {
    public static ArrayList<Conference> readConference(String filePath){
        ArrayList<Conference> conferences=new ArrayList<>();

        try(BufferedReader br =new BufferedReader(new FileReader(filePath))){
            String line;
            br.readLine();
            while((line=br.readLine())!=null){
                String[] data = line.split(",");
                Conference conference =new Conference(
                        Integer.parseInt(data[0]),
                        data[1].trim(),
                        data[2].trim(),
                        data[3].trim(),
                        data[4].trim(),
                        Integer.parseInt(data[5]),
                        Integer.parseInt(data[6]),
                        Double.parseDouble(data[7]),
                        data[8].trim()

                );


                  conferences.add(conference);
               }






        }catch (IOException e) {
            e.printStackTrace();
        }



        return conferences;
    }

}
