import java.util.Comparator;

public class Sorter implements Comparator<Festival> {
    @Override
    public int compare(Festival o1, Festival o2) {
 return Double.compare(o1.getTAXA_ACCES(),o2.TAXA_ACCES);
    }
}
