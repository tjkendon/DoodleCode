package ca.kendon.categoryvote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Category {

    final private String name;

    final private int victoryPointReduction;

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

    public String getName() {
        return name;
    }

    public int getVictoryPointReduction() {
        return victoryPointReduction;
    }

    public List<String> getVictoryItems() {
        return victoryItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (victoryPointReduction != category.victoryPointReduction) return false;
        if (name != null ? !name.equals(category.name) : category.name != null) return false;
        return victoryItems != null ? victoryItems.equals(category.victoryItems) : category.victoryItems == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + victoryPointReduction;
        result = 31 * result + (victoryItems != null ? victoryItems.hashCode() : 0);
        return result;
    }
}
