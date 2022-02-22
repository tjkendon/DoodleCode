package ca.kendon.categoryvote;

import java.util.ArrayList;

public class CategoryVotes implements Comparable<CategoryVotes> {

    private final Category cateogory;
    private ArrayList<String> victoryItems;

    private int currentPoints = 0;

    public CategoryVotes(Category cateogory) {
        this.cateogory = cateogory;
        victoryItems = new ArrayList<>();
        victoryItems.addAll(cateogory.getVictoryItems());
    }

    public void addPoints(int points) {
        currentPoints += points;
    }

    /**
     *
     * If category wins a round, it's total is reduced by the victory point reduction and it returns either
     * the next item in the victory items, or the category name.
     *
     * @return either the next victory item or the category name
     */
    public String winAction() {
        currentPoints -= cateogory.getVictoryPointReduction();
        if (victoryItems.size() > 0) {
            return victoryItems.remove(0);
        }
        return cateogory.getName();
    }


    public boolean canWin() {
        return currentPoints >= cateogory.getVictoryPointReduction();
    }

    public Category getCateogory() {
        return cateogory;
    }

    public ArrayList<String> getVictoryItems() {
        return victoryItems;
    }

    public int getCurrentPoints() {
        return currentPoints;
    }

    @Override
    public int compareTo(CategoryVotes o) {
        return o.currentPoints - this.currentPoints;

    }
}
