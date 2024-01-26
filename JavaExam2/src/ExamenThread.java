import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ExamenThread extends Thread {
ArrayList<Examen> Examen;
String filepath;

    public ExamenThread(ArrayList<Examen> examen, String filepath) {
       this.Examen = examen;
        this.filepath = filepath;
    }

    public void run(){

    try{
        BufferedReader br =new BufferedReader(new FileReader(filepath));
        String line;
        br.readLine();
        while((line=br.readLine())!=null){
            String[] data=line.split(",");
            Examen ex=new Examen(
                    Integer.parseInt(data[0]),
                    data[1],
                    data[2],
                    LocalDate.parse(data[3]),
                    Integer.parseInt(data[4]),
                    Integer.parseInt(data[5]),
                    Integer.parseInt(data[6]),
                    Integer.parseInt(data[7]),
                    data[8]

            );
            Examen.add(ex);



        }



    }catch(IOException e){
        e.printStackTrace();
    }



}



}

