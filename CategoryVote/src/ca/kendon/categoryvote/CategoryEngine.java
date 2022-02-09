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

    public void evaluateQuestions(List<Question> questions) {

        for (Question q : questions) {
            for (Map.Entry<Category, Integer> e : q.getChoice().getPointAssignment().entrySet()) {
                if (categories.contains(e.getKey())) {
                    e.getKey().addPoints(e.getValue());
                }
            }
        }
    }

    public List<String> evaluateCategories(int winners) {
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
