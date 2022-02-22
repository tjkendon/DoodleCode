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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Option option = (Option) o;

        if (text != null ? !text.equals(option.text) : option.text != null) return false;
        return pointAssignment != null ?
                pointAssignment.equals(option.pointAssignment) : option.pointAssignment == null;
    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + (pointAssignment != null ? pointAssignment.hashCode() : 0);
        return result;
    }
}
