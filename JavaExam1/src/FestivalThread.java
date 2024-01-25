import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class FestivalThread  extends Thread{
ArrayList<Festival> Festival;
String filepath;

    public FestivalThread(ArrayList<Festival> Festival, String filepath) {
        this.Festival = Festival;
        this.filepath = filepath;
    }

    public void run(){


        try(BufferedReader br=new BufferedReader(new FileReader(filepath))){;
            String line;
            br.readLine();
            while((line=br.readLine())!=null){
                String[] data = line.split(",");
                Festival fl=new Festival(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        LocalDate.parse(data[3]),
                        LocalDate.parse(data[4]),
                        Integer.parseInt(data[5]),
                        data[6],
                        Float.parseFloat(data[7]),
                        data[8]


                );
                Festival.add(fl);

            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

