package ca.kendon.categoryvote;

import java.util.HashMap;
import java.util.Map;

public class Option {

    private String text;
    private Map<Category, Integer> pointAssignment;

    public Option(String text, Map<Category, Integer> pointAssignment) {
        this.text = text;
        this.pointAssignment = pointAssignment;
    }

    public String getText() {
        return text;
    }

    public Map<Category, Integer> getPointAssignment() {
        return new HashMap<>(pointAssignment);
    }

}
