package ca.kendon.food_o_rac_o_cycle;

import java.util.*;

/**
 *
 * A generator for a random meal based on the weighted probabilities.
 *
 */
public class FoodORacOCycleChooser {

    /**
     * List of all possible meals
     */
    List<Meal> meals = new ArrayList<>();

    /**
     * Random for selecting meals
     */
    Random r = new Random();
    
    /**
     *
     * Adds a list of new meals to chooser.
     *
     * @param newMeals the list of meals to add.
     */
    public void addMeals(List<Meal> newMeals) {
        meals.addAll(newMeals);
    }

    /**
     *
     * Returns a randomly selected meal tilted towards the meals with higher weights
     *
     * @return a randomly selected meal
     */
    public Meal chooseMeal () {

        Map<Integer, Meal> draw = new HashMap<>();

        // build table of weighted chances for drawing
        int drawRange = 0;
        for (Meal m : meals) {
            draw.put(drawRange+=m.getWeight(), m);
        }

        // choose random value against the table
        int drawValue = r.nextInt(drawRange);

        // sort the table to look up the value and find the meal
        List<Integer> values = new ArrayList<>(draw.keySet());
        Collections.sort(values);
        int i = 0;
        for (; i <= values.size() - 1; i++) {
            if (values.get(i) > drawValue) {
                return draw.get(values.get(i));
            }
        }

        return draw.get(values.get(i - 1));
    }

}
