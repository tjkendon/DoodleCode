package ca.kendon.food_o_rac_o_cycle;

import org.jetbrains.annotations.NotNull;

/**
 *
 * Contains the information about meals, including a name and a weight.
 *
 */
public class Meal {

    /**
     * The displayed name of the meal
     */
    private final String name;
    /**
     * The weight of the meal getting selected
     */
    private final int weight;

    /**
     *
     * Creates a new meal with the given name and weight.
     *
     * @param name the display name of the meal
     * @param weight higher weights are more likely to be selected
     */
    public Meal(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    /**
     *
     * Creates a new meal with the name and weight parsed from the string.
     *
     * Format of string is: name, weight
     *
     * @param mealString the string to parse into name and weight
     */
    public Meal(@NotNull String mealString) {
        String[] nameData = mealString.split(", ");
        this.name = nameData[0].trim();
        this.weight = Integer.parseInt(nameData[1].trim());
    }

    /**
     *
     * Returns the name of the meal as it should be displayed
     *
     * @return display name meal
     */
    public String getName() {
        return name;
    }

    /**
     *
     * Returns the weight of the meal, higher weights are more likely to be selected
     *
     * @return the meal's weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Returns the name of the meal for display.
     */
    @Override
    public String toString() {
        return name;
    }
}
