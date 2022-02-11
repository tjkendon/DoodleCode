package ca.kendon.categoryvote;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class CategoryEngine {

    final private List<Category> categories;

    public CategoryEngine(List<Category> categories) {
        this.categories = categories;
    }

    public List<String> evaluate(List<Response> responses, int winners) {

        for (Response r : responses) {
            for (Map.Entry<Category, Integer> e : r.getChoice().getPointAssignment().entrySet()) {
                if (categories.contains(e.getKey())) {
                    e.getKey().addPoints(e.getValue());
                }
            }
        }
        List<String> results = new ArrayList<>();
        for (;winners > 0; winners--) {
            Collections.sort(categories);
            if (categories.get(0).canWin()) {
                results.add(categories.get(0).winAction());
            }
        }
        return results;
    }







}
