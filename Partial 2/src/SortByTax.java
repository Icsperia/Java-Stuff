import java.util.Comparator;

public class SortByTax implements Comparator<Conference> {
    @Override
    public int compare(Conference conference1, Conference conference2) {
        return Double.compare(conference2.getRegistrationFee(), conference1.getRegistrationFee());
    }
}
