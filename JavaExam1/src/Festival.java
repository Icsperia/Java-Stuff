import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Festival {
    ArrayList<Festival> rock;
    ArrayList<Festival> nonrock;
    int ID;
    String NUME;
    String LOCATIE;
    LocalDate DATA_START;
    LocalDate DATA_FINAL;
    int NR_ARTISTI;
    String GEN_MUZICAL;
    float TAXA_ACCES;
    String STATUS;

    public Festival(int ID, String NUME, String LOCATIE, LocalDate DATA_START, LocalDate DATA_FINAL, int NR_ARTISTI, String GEN_MUZICAL, float TAXA_ACCES, String STATUS) {
        this.ID = ID;
        this.NUME = NUME;
        this.LOCATIE = LOCATIE;
        this.DATA_START = DATA_START;
        this.DATA_FINAL = DATA_FINAL;
        this.NR_ARTISTI = NR_ARTISTI;
        this.GEN_MUZICAL = GEN_MUZICAL;
        this.TAXA_ACCES = TAXA_ACCES;
        this.STATUS = STATUS;
        this.rock = new ArrayList<>();
        this.nonrock = new ArrayList<>();
    }

    public Festival() {
        this.rock = new ArrayList<>();
        this.nonrock = new ArrayList<>();
    }



    public static  ArrayList<Festival> FestivalReader(String filepath){
            ArrayList<Festival> festival=new ArrayList<>();
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
    festival.add(fl);

}


            } catch (IOException e) {
                e.printStackTrace();
            }
           return festival;
       }

    @Override
    public String toString() {
        return "Festival{" +
                "ID=" + ID +
                ", NUME='" + NUME + '\'' +
                ", LOCATIE='" + LOCATIE + '\'' +
                ", DATA_START=" + DATA_START +
                ", DATA_FINAL=" + DATA_FINAL +
                ", NR_ARTISTI=" + NR_ARTISTI +
                ", GEN_MUZICAL='" + GEN_MUZICAL + '\'' +
                ", TAXA_ACCES=" + TAXA_ACCES +
                ", STATUS='" + STATUS + '\'' +
                '}';
    }

public void RockGenre(ArrayList<Festival> festival){
 for(Festival m:festival)
    if("Rock".equalsIgnoreCase(m.GEN_MUZICAL.trim())){
       rock.add(m);
    }else{
        nonrock.add(m);
    }
}

    public ArrayList<Festival> getRock() {
        return rock;
    }

    public void setRock(ArrayList<Festival> rock) {
        this.rock = rock;
    }

    public ArrayList<Festival> getNonrock() {
        return nonrock;
    }

    public void setNonrock(ArrayList<Festival> nonrock) {
        this.nonrock = nonrock;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNUME() {
        return NUME;
    }

    public void setNUME(String NUME) {
        this.NUME = NUME;
    }

    public String getLOCATIE() {
        return LOCATIE;
    }

    public void setLOCATIE(String LOCATIE) {
        this.LOCATIE = LOCATIE;
    }

    public LocalDate getDATA_START() {
        return DATA_START;
    }

    public void setDATA_START(LocalDate DATA_START) {
        this.DATA_START = DATA_START;
    }

    public LocalDate getDATA_FINAL() {
        return DATA_FINAL;
    }

    public void setDATA_FINAL(LocalDate DATA_FINAL) {
        this.DATA_FINAL = DATA_FINAL;
    }

    public int getNR_ARTISTI() {
        return NR_ARTISTI;
    }

    public void setNR_ARTISTI(int NR_ARTISTI) {
        this.NR_ARTISTI = NR_ARTISTI;
    }

    public String getGEN_MUZICAL() {
        return GEN_MUZICAL;
    }

    public void setGEN_MUZICAL(String GEN_MUZICAL) {
        this.GEN_MUZICAL = GEN_MUZICAL;
    }

    public float getTAXA_ACCES() {
        return TAXA_ACCES;
    }

    public void setTAXA_ACCES(float TAXA_ACCES) {
        this.TAXA_ACCES = TAXA_ACCES;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }
}



