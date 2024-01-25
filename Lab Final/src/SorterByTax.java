import java.util.Comparator;

public class SorterByTax implements Comparator<Conference> {

    public int compare(Conference T1,Conference T2){

    return Double.compare(T2.getRegistrationFee(), T1.getRegistrationFee());
}


}