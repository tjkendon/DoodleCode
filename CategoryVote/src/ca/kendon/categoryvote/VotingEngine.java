package ca.kendon.categoryvote;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class VotingEngine {

    final private List<CategoryVotes> categoryVotes;

    public VotingEngine(List<Category> categories) {

        categoryVotes = new ArrayList<>();
        for (Category c : categories) {
            categoryVotes.add(new CategoryVotes(c));
        }




    }

    public List<String> evaluate(List<Response> responses, int winners) {

        for (Response r : responses) {
            for (Map.Entry<Category, Integer> e : r.getChoice().getPointAssignment().entrySet()) {
                for (CategoryVotes v : categoryVotes) {
                    if (v.getCateogory().equals(e.getKey())) {
                        v.addPoints(e.getValue());
                    }
                }
            }
        }

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
