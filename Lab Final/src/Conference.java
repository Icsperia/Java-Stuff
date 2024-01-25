public class Conference {
 int id;
     String title;
    String location;
   String startDate;
     String endDate;
  int maxParticipants;
     int availableRooms;
    double registrationFee;
    String status;

    public Conference(int id, String title, String location, String startDate, String endDate, int maxParticipants, int availableRooms, double registrationFee, String status) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.maxParticipants = maxParticipants;
        this.availableRooms = availableRooms;
        this.registrationFee = registrationFee;
        this.status = status;
    }

    public Conference() {
        // Default constructor
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(int availableRooms) {
        this.availableRooms = availableRooms;
    }

    public double getRegistrationFee() {
        return registrationFee;
    }

    public void setRegistrationFee(double registrationFee) {
        this.registrationFee = registrationFee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Conferinta: {Titlu=" + title +
                ", Data_inceput=" + startDate +
                ", Data_sfarsit=" + endDate +
                ", Participanti_inscrisi=" + maxParticipants +
                ", Status=" + status +
                ",Taxa="+registrationFee+"}";
    }
}
