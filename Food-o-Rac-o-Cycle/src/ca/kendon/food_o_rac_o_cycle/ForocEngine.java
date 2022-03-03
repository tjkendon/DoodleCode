package ca.kendon.food_o_rac_o_cycle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ForocEngine {

    List<Meal> meals;

    public ForocEngine(File mealFile) throws FileNotFoundException {
        meals = loadMeals(mealFile);
    }

    private List<Meal> loadMeals(File mealFile) throws FileNotFoundException {

        List<Meal> meals = new ArrayList<>();

        Scanner scanner = new Scanner(mealFile);
        while (scanner.hasNextLine()) {
            meals.add(new Meal(scanner.nextLine()));
        }

        scanner.close();

        return meals;

    }

    public Meal choose() {
        FoodORacOCycle foodORacOCycle = new FoodORacOCycle();
        foodORacOCycle.addMeals(meals);
        return foodORacOCycle.chooseMeal();
    }

}
