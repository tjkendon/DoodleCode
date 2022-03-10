package ca.kendon.categoryvote;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


/**
 *
 * Engine to take responses and calcuates points, then winning categories.
 *
 */
public class VotingEngine {

    /**
     * List of categories
     */
    final private List<Category> categories;

    /**
     * Creates a new engine for the given categories.
     *
     * @param categories list of categories, votes/points will be calucalted for
     */
    public VotingEngine(List<Category> categories) {


        this.categories = categories;
    }

    /**
     *
     * Takes the list of responses, calculate the total points for the set categories
     *
     * @param responses the list of responces which the points will be calulated from
     * @param winners the number of winners for the engine to select
     *
     * @return a list of winning results (the length of winners) based on the points calculated from the
     * responses and the point values of the categories
     */
    public List<String> evaluate(List<Response> responses, int winners) {

        // build list of all vote counts for all categories
        List<CategoryVoteCounter> categoryVotes = new ArrayList<>();
        for (Category c : categories) {
            categoryVotes.add(new CategoryVoteCounter(c));
        }

        // process all responses and add appropriate points to the respective categories
        for (Response r : responses) {
            for (Map.Entry<Category, Integer> e : r.getChoice().getPointAssignment().entrySet()) {
                for (CategoryVoteCounter v : categoryVotes) {
                    if (v.getCateogory().equals(e.getKey())) {
                        v.addPoints(e.getValue());
                    }
                }
            }
        }

        // process all points and get values from the categories.
        List<String> results = new ArrayList<>();
        for (; winners > 0; winners--) {
            Collections.sort(categoryVotes);
            if (categoryVotes.get(0).canWin()) {
                results.add(categoryVotes.get(0).winAction());
            }
        }
        return results;
    }







}
