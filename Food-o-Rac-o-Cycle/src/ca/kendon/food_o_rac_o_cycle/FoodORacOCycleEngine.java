package ca.kendon.food_o_rac_o_cycle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * Engine to manage loading food from files into the Chooser.
 *
 */
public class FoodORacOCycleEngine {

    /**
     * The meals being loaded from file.
     */
    private List<Meal> meals;

    /**
     *
     * Sets up the engine loading meals from the given file.
     *
     * @param mealFile the file the meals will be loaded from
     *
     * @throws FileNotFoundException if the file cannot be found
     */
    public FoodORacOCycleEngine(File mealFile) throws FileNotFoundException {
        meals = loadMeals(mealFile);
    }

    /**
     *
     * Loads the meals from the file.
     *
     * @param mealFile the file the meals will be loaded from
     *
     * @return a list of meals found in the file
     *
     * @throws FileNotFoundException if the file cannot be found
     */
    private List<Meal> loadMeals(File mealFile) throws FileNotFoundException {

        List<Meal> meals = new ArrayList<>();

        Scanner scanner = new Scanner(mealFile);
        while (scanner.hasNextLine()) {
            meals.add(new Meal(scanner.nextLine()));
        }

        scanner.close();

        return meals;

    }

    /**
     *
     * Chooses a meal from those loaded into the Food'O'Rac'O'Cycle chooser.
     *
     * @return one randomly selected meal
     */
    public Meal choose() {
        FoodORacOCycleChooser foodORacOCycle = new FoodORacOCycleChooser();
        foodORacOCycle.addMeals(meals);
        return foodORacOCycle.chooseMeal();
    }

}
