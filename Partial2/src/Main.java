import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<WorldCuisines> allDishes = readDataFromCSV("Cuisine.csv");

        WorldCuisines worldCuisines = new WorldCuisines();
        worldCuisines.filterDishesBySpiceLevel(allDishes);

        // Iterate through all dishes


        ArrayList<WorldCuisines> spicyDishes = worldCuisines.getSpicyDishesList();
        ArrayList<WorldCuisines> notSpicyDishes = worldCuisines.getNotSpicyDishesList();

        System.out.println("\nNot Spicy Dishes:");
        for (WorldCuisines dish : notSpicyDishes) {
            System.out.println(dish);
        }

        System.out.println("\nSpicy Dishes:");
        for (WorldCuisines dish : spicyDishes) {
            System.out.println(dish);
        }
worldCuisines.sortbuyear();
        worldCuisines.printNotSpicyDish();
    }

    public static ArrayList<WorldCuisines> readDataFromCSV(String filePath) {
        ArrayList<WorldCuisines> dishes = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Skip the header line
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 9) {
                    WorldCuisines dish = new WorldCuisines(data[0], data[1], data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4]), data[5], Integer.parseInt(data[6]), Integer.parseInt(data[7]), data[8]);
                    dishes.add(dish);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dishes;
    }
}
