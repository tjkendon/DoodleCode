package ca.kendon.food_o_rac_o_cycle;

public class Meal {

    private final String meal;
    private final int weight;

    public Meal(String meal, int weight) {
        this.meal = meal;
        this.weight = weight;
    }

    public String getMeal() {
        return meal;
    }

    public int getWeight() {
        return weight;
    }
}
