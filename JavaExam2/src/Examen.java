import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Examen implements Comparable<Examen> {

     int NUMAR_CANDIDAT;
    String NUME;
     String EXAMEN;
     LocalDate DATA_EXAMEN;
     int NOTA_SCRIERE;

     int NOTA_CITIRE;
        int NOTA_ASCULTARE;
     int NOTA_VORBIRE;
     String NOTA_FINALA;


    public Examen(int NUMAR_CANDIDAT, String NUME, String EXAMEN, LocalDate DATA_EXAMEN, int NOTA_SCRIERE, int NOTA_CITIRE, int NOTA_ASCULTARE, int NOTA_VORBIRE, String NOTA_FINALA) {
        this.NUMAR_CANDIDAT = NUMAR_CANDIDAT;
        this.NUME = NUME;
        this.EXAMEN = EXAMEN;
        this.DATA_EXAMEN = DATA_EXAMEN;
        this.NOTA_SCRIERE = NOTA_SCRIERE;
        this.NOTA_CITIRE = NOTA_CITIRE;
        this.NOTA_ASCULTARE = NOTA_ASCULTARE;
        this.NOTA_VORBIRE = NOTA_VORBIRE;
        this.NOTA_FINALA = NOTA_FINALA;
    }

    @Override
    public String toString() {
        return "Examen{" +
                "NUMAR_CANDIDAT=" + NUMAR_CANDIDAT +
                ", NUME='" + NUME + '\'' +
                ", EXAMEN='" + EXAMEN + '\'' +
                ", DATA_EXAMEN=" + DATA_EXAMEN +
                ", NOTA_SCRIERE=" + NOTA_SCRIERE +
                ", NOTA_CITIRE=" + NOTA_CITIRE +
                ", NOTA_ASCULTARE=" + NOTA_ASCULTARE +
                ", NOTA_VORBIRE=" + NOTA_VORBIRE +
                ", NOTA_FINALA=" + NOTA_FINALA +
                '}';
    }
    public String toCsvString() {
        return String.format("%d,%s,%s,%s,%d,%d,%d,%d,%s",
                NUMAR_CANDIDAT, NUME, EXAMEN, DATA_EXAMEN, NOTA_SCRIERE,
                NOTA_CITIRE, NOTA_ASCULTARE, NOTA_VORBIRE, NOTA_FINALA);
    }
public static ArrayList<Examen> ExamenReader(String filepath){
        ArrayList<Examen> Examen=new ArrayList<>();

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


     return Examen;
}


    @Override
    public int compareTo(Examen o) {
        return this.NOTA_FINALA.compareTo(o.NOTA_FINALA);
    }




public  static void WriteToExams(String output,ArrayList<Examen> exmas){
try (BufferedWriter bw =new BufferedWriter(new FileWriter(output))){
bw.write("NUMAR_CANDIDAT,NUME,EXAMEN,DATA_EXAMEN,NOTA_SCRIERE,NOTA_CITIRE,NOTA_ASCULTARE,NOTA_VORBIRE,NOTA_FINALA");
bw.newLine();
for(Examen ex:exmas){
    bw.write(ex.toCsvString());
bw.newLine();
}

}catch(IOException e){
    e.printStackTrace();
}


}
}
