package ca.kendon.categoryvote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Category {

    final private String name;

    final private int victoryPointReduction;

    private int totalPoints = 0;

    final List<String> victoryItems;

    public Category(String name, int victoryPointReduction) {
        this.name = name;
        this.victoryPointReduction = victoryPointReduction;
        this.victoryItems = new ArrayList<>();
    }

    public Category(String name, int victoryPointReduction, List<String> victoryItems) {
        this.name = name;
        this.victoryPointReduction = victoryPointReduction;
        this.victoryItems = victoryItems;
    }

    private void addPoints(int points) {
        this.totalPoints += points;
    }

    public String getName() {
        return name;
    }

    public int getVictoryPointReduction() {
        return victoryPointReduction;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public List<String> getVictoryItems() {
        return victoryItems;
    }

    /**
     *
     * If category wins a round, it's total is reduced by the victory point reduction and it returns either
     * the next item in the victory items, or the category name.
     *
     * @return either the next victory item or the category name
     */
    public String winAction() {
        totalPoints -= victoryPointReduction;
        if (victoryItems.size() > 0) {
            return victoryItems.remove(0);
        }
        return name;
    }

}
