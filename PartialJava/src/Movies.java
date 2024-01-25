import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class Movies {
    int id;
    String title;
    String director;
    String genre;
int year;
    double duration;
double budget;
    double rating;

    public Movies(int id, String title, String director, String genre,int year ,double duration, double budget, double rating) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.year=year;
        this.duration = duration;
        this.budget = budget;
        this.rating = rating;


    }

    public int getYear() {
        return year;
    }

    public double getBudget() {
        return budget;
    }

    public double getDuration() {
        return duration;
    }

    public String getGenre() {
        return genre;
    }

    public static ArrayList<Movies> readMovies(String filepath) {
        ArrayList<Movies> mv = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {

            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Movies movies=new Movies(
                         Integer.parseInt(data[0]),
                        data[1],
              data[2],
              data[3],
             Integer.parseInt(data[4]),
             Double.parseDouble(data[5]),
             Double.parseDouble(data[6]),
             Double.parseDouble(data[7])

                );

                mv.add(movies);

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return mv;

        }
    public String toString(){

        return("Id:"+id+", Title: "+title+", Rating: "+rating+",Year: "+year+",Budget: "+budget+",Duration: "+duration+", Genre: "+genre);
}
}