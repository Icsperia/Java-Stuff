public class Ticket {

    private int id;
    private String ruta;
    private String statiePlecare;
    private String statieSosire;
    private String oraPlecare;
    private String oraSosire;
    private int clasa;
    private String tipBilet;
    private double pret;
    private String status;

    // Constructor with parameters
    public Ticket(int id, String ruta, String statiePlecare, String statieSosire, String oraPlecare, String oraSosire, int clasa, String tipBilet, double pret, String status) {
        this.id = id;
        this.ruta = ruta;
        this.statiePlecare = statiePlecare;
        this.statieSosire = statieSosire;
        this.oraPlecare = oraPlecare;
        this.oraSosire = oraSosire;
        this.clasa = clasa;
        this.tipBilet = tipBilet;
        this.pret = pret;
        this.status = status;
    }

    // Default constructor
    public Ticket() {
        // Initialize with default values if needed
        this.id = 0;
        this.ruta = "";
        this.statiePlecare = "";
        this.statieSosire = "";
        this.oraPlecare = "";
        this.oraSosire = "";
        this.clasa = 0;
        this.tipBilet = "";
        this.pret = 0.0;
        this.status = "";
    }
    public int getId() {
        return id;
    }

    public String getRuta() {
        return ruta;
    }

    public String getStatiePlecare() {
        return statiePlecare;
    }

    public String getStatieSosire() {
        return statieSosire;
    }

    public String getOraPlecare() {
        return oraPlecare;
    }

    public String getOraSosire() {
        return oraSosire;
    }

    public int getClasa() {
        return clasa;
    }

    public String getTipBilet() {
        return tipBilet;
    }

    public double getPret() {
        return pret;
    }

    public String getStatus() {
        return status;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public void setStatiePlecare(String statiePlecare) {
        this.statiePlecare = statiePlecare;
    }

    public void setStatieSosire(String statieSosire) {
        this.statieSosire = statieSosire;
    }

    public void setOraPlecare(String oraPlecare) {
        this.oraPlecare = oraPlecare;
    }

    public void setOraSosire(String oraSosire) {
        this.oraSosire = oraSosire;
    }

    public void setClasa(int clasa) {
        this.clasa = clasa;
    }

    public void setTipBilet(String tipBilet) {
        this.tipBilet = tipBilet;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    @Override
    public String toString() {
        return String.format("Ticket: {ID=%d, Ruta=%s, Statie_plecare=%s, Statie_sosire=%s, Ora_plecare=%s, " +
                        "Ora_sosire=%s, Clasa=%d, Tip_bilet=%s, Pret=%.2f, Status=%s }",
                id, ruta, statiePlecare, statieSosire, oraPlecare, oraSosire, clasa, tipBilet, pret, status);
    }
}
