import java.util.Comparator;

public class SortByPrice implements Comparator<Ticket> {

public int compare(Ticket t1, Ticket t2){
    return Double.compare(t2.getPret(),t1.getPret());
}
}
