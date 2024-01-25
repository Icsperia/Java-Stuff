import java.util.*;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<Movies> longMovies=new ArrayList<>();
        ArrayList<Movies> shortMovies=new ArrayList<>();

        String filepath="D:\\Documents\\PartialJava\\movies.csv";
        ArrayList<Movies> mv=Movies.readMovies(filepath);

for(Movies movies:mv){
    int titleLength=movies.title.replaceAll("\\s" ," ").length();
  if(titleLength>10){
      longMovies.add(movies);
  }else{
      shortMovies.add(movies);
  }
}
        System.out.println("LongMovies");
        for(Movies movies:longMovies){
            System.out.println(movies);
        }

    System.out.println("ShortMovies");
    for(Movies movies:shortMovies){
        System.out.println(movies);
    }

System.out.println("LongMovies after 2000");
for(Movies movies:longMovies){
    if(movies.getYear()>2000)
    System.out.println(movies);
}
       shortMovies.removeIf(movie -> movie.getDuration() <= 120);

// Sort the remaining short movies by budget in ascending order
        Collections.sort(shortMovies, Comparator.comparingDouble(Movies::getBudget));
System.out.println("ShortMovies by duration");
for(Movies movies:shortMovies){
        System.out.println(movies);
    }
        Map<String, ArrayList<Movies>> groupedLongMoviesByGenre = longMovies.stream()
                .filter(movie -> !movie.getGenre().equalsIgnoreCase("Animation"))
                .collect(Collectors.groupingBy(Movies::getGenre, Collectors.toCollection(ArrayList::new)));

        // Print the grouped long movies by genre
        System.out.println("\nLong Movies grouped by Genre (excluding Animation):");
        groupedLongMoviesByGenre.forEach((genre, movies) -> {
            System.out.println("\nGenre: " + genre);
            movies.forEach(System.out::println);
        });
    }}
