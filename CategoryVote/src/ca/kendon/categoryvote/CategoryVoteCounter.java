package ca.kendon.categoryvote;

import java.util.ArrayList;

/**
 *
 * Records votes for Category as calculated from reponses and tracks resources to
 * return as the category wins rounds.
 *
 */
public class CategoryVoteCounter implements Comparable<CategoryVoteCounter> {

    /**
     * The Category votes are being recorded for.
     */
    private final Category cateogory;
    /**
     * A copy of the category's victory items which is used to provide strings
     * each time the cateogry completes its win action.
     */
    private ArrayList<String> victoryItems;

    /**
     * The points accrued for this cateogry at this point in time.
     */
    private int currentPoints = 0;

    /**
     *
     * Constructs a new counter with a copy of the category's victory items to return if it wins and
     * the current point counter set to zero.
     *
     * @param cateogory
     */
    public CategoryVoteCounter(Category cateogory) {
        this.cateogory = cateogory;
        victoryItems = new ArrayList<>();
        victoryItems.addAll(cateogory.getVictoryItems());
    }

    /**
     *
     * Adds the new points to the current point counter.
     *
     * @param points
     */
    public void addPoints(int points) {
        currentPoints += points;
    }

    /**
     *
     * If category wins a round, it's total is reduced by the victory point reduction and it returns either
     * the next item in the victory items, or the category name if there are no victory items.
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


    /**
     *
     * A category must have at least as many points as its Victory Point Reduction value to win
     * a round.
     *
     * @return
     */
    public boolean canWin() {
        return currentPoints >= cateogory.getVictoryPointReduction();
    }

    /**
     *
     * Returns the category for this counter.
     *
     * @return
     */
    public Category getCateogory() {
        return cateogory;
    }

    /**
     *
     * Returns the current victory item list
     *
     * @return
     */
    public ArrayList<String> getVictoryItems() {
        return victoryItems;
    }

    /**
     *
     * Returns the current points.
     *
     * @return
     */
    public int getCurrentPoints() {
        return currentPoints;
    }

    /**
     *
     * Sorts counters in order of highest points first. Returns +ive if o has more points, -ive if this has more points.
     *
     * @param o the counter to compair to.
     * @return
     */
    @Override
    public int compareTo(CategoryVoteCounter o) {
        return o.currentPoints - this.currentPoints;

    }
}
