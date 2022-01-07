package ca.kendon.food_o_rac_o_cycle;

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
