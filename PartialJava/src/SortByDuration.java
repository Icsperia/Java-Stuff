import java.util.Comparator;

public class SortByDuration implements Comparator<Movies> {
public int compare(Movies movie1,Movies movie2){
    if(movie1.getDuration()<120 && movie2.getDuration()<120){
        return Double.compare(movie1.getBudget(),movie2.getBudget());
    }return 0  ;
}


}
