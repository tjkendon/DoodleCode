package ca.kendon.categoryvote;

import java.util.List;

public class Category {

    final private String name;

    final private int victoryPointReduction;

    private int totalPoints = 0;

    final List<String> victoryItems;

    public Category(String name, int victoryPointReduction, List<String> victoryItems) {
        this.name = name;
        this.victoryPointReduction = victoryPointReduction;
        this.victoryItems = victoryItems;
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
}
