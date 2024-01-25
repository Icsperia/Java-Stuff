import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.Inet4Address;
import java.util.*;

class WorldCuisines {
    private String country;
    private String dishName;
    private String mainIngredient;
    private int cookingTimeMin;
    private int servings;
    private String spiceLevel;
    private int calories;
    private int yearIntroduced;
    private String chefName;
    private ArrayList<WorldCuisines> _spicyDishesList;
    private ArrayList<WorldCuisines> _notSpicyDishesList;

    public WorldCuisines(String country, String dishName, String mainIngredient, int cookingTimeMin, int servings,
                String spiceLevel, int calories, int yearIntroduced, String chefName) {
        this.country = country;
        this.dishName = dishName;
        this.mainIngredient = mainIngredient;
        this.cookingTimeMin = cookingTimeMin;
        this.servings = servings;
        this.spiceLevel = spiceLevel;
        this.calories = calories;
        this.yearIntroduced = yearIntroduced;
        this.chefName = chefName;
        _spicyDishesList = new ArrayList<>();
        _notSpicyDishesList = new ArrayList<>();   }
     public WorldCuisines() {
         _spicyDishesList = new ArrayList<>();
         _notSpicyDishesList = new ArrayList<>();
     }

    public int getYearIntroduced() {
        return yearIntroduced;
    }

    public void setYearIntroduced(int yearIntroduced) {
        this.yearIntroduced = yearIntroduced;
    }

    public String getSpiceLevel() {
        return spiceLevel;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getCalories() {
        return calories;
    }

    public String getMainIngredient() {
        return mainIngredient;
    }

    public void setMainIngredient(java.lang.String mainIngredient) {
        this.mainIngredient = mainIngredient;
    }

    public int getCookingTimeMin() {
        return cookingTimeMin;
    }

    public void setCookingTimeMin(int cookingTimeMin) {
        this.cookingTimeMin = cookingTimeMin;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "country='" + country + '\'' +
                ", dishName='" + dishName + '\'' +
                ", spiceLevel='" + spiceLevel + '\'' +
                ", CookTime='" + cookingTimeMin + '\'' +
                ", MainIngredient='" + mainIngredient + '\'' +
                '}';
}






     public void filterDishesBySpiceLevel(ArrayList<WorldCuisines> dishes) {
         for (WorldCuisines dish : dishes) {
             if ("Hot".equalsIgnoreCase(dish.getSpiceLevel().trim())) {
                 _spicyDishesList.add(dish);
             } else {
                 _notSpicyDishesList.add(dish);
             }
         }
     }

     public ArrayList<WorldCuisines> getSpicyDishesList() {
         return _spicyDishesList;
     }

     public ArrayList<WorldCuisines> getNotSpicyDishesList() {
         return _notSpicyDishesList;
     }

    public void Cooktime( WorldCuisines wr) {


      System.out.println("\nSpicy");
      for(WorldCuisines dish:_spicyDishesList){
          if(dish.getCookingTimeMin()<50){
              System.out.println(dish.toString());

          }



      }



    }
    public String toStringShort() {
        return "Dish{" +
                "dishName='" + dishName + '\'' +
                ", MainIngredient='" + mainIngredient + '\'' +
                ", Calories='" + calories + '\'' +
                '}';
    }
public void sortbuyear(){
    Collections.sort(_notSpicyDishesList, Comparator.comparingInt(WorldCuisines::getYearIntroduced).reversed());


}
public void printNotSpicyDish(){

        System.out.println("\nNot Spicy");
                int currentDecade=-1;
      for(WorldCuisines dish:_notSpicyDishesList){
          int decade=dish.getYearIntroduced()/10*10;
          if(decade!=currentDecade){
              System.out.println("\n"+decade+"s:");
              currentDecade=decade;

          }

          System.out.println(dish);

      }





}

}
