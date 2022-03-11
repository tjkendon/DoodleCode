package ca.kendon.categoryvote;

import java.util.ArrayList;

import java.util.List;
import java.util.Objects;

/**
 *
 * A Category, including a name, the number of points the category is reduced by each time it wins,
 * and a possible list of which are "won" when the category wins
 *
 */
public class Category {

    final private String name;

    final private int victoryPointReduction;

    final List<String> victoryItems;

    /**
     *
     * Constructs a new Category with name and victory point reduction and an empty list of
     * victory items.
     *
     * @param name the category name, used as identifier
     * @param victoryPointReduction the number of points the total is reduced by while determining vote results for a
     *                              win for this category
     */
    public Category(String name, int victoryPointReduction) {
        this.name = name;
        this.victoryPointReduction = victoryPointReduction;
        this.victoryItems = new ArrayList<>();
    }

    /**
     *
     * Constructs a new Category with name and victory point reduction and a list of
     * victory items.
     *
     * @param name the category name, used as identifier
     * @param victoryPointReduction the number of points the total is reduced by while determining vote results for a
     *                              win for this category

     * @param victoryItems list of items which are returned in sequence when this category wins a vote
     */
    public Category(String name, int victoryPointReduction, List<String> victoryItems) {
        this.name = name;
        this.victoryPointReduction = victoryPointReduction;
        this.victoryItems = victoryItems;
    }

    /**
     *
     * Returns the name of the category, which should be an identifier
     *
     * @return the category name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * Returns the the number of points the total is reduced by while determining vote results for a
     * win for this category
     *
     * @return number of points
     */
    public int getVictoryPointReduction() {
        return victoryPointReduction;
    }

    /**
     *
     * The list of items which can be won when this category wins a voting round.
     *
     * @return the list of items
     */
    public List<String> getVictoryItems() {
        return victoryItems;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (victoryPointReduction != category.victoryPointReduction) return false;
        if (!Objects.equals(name, category.name)) return false;
        return Objects.equals(victoryItems, category.victoryItems);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + victoryPointReduction;
        result = 31 * result + (victoryItems != null ? victoryItems.hashCode() : 0);
        return result;
    }
}
