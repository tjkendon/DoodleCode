package ca.kendon.categoryvote;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * A possible answer to a question. Includes the text and the assignment of points to
 * categories.
 *
 */

public class Option {

    /**
     * The text of the option, also the identifier for the option
     */
    private String text;
    /**
     * The assignment of points to categories.
     */
    private Map<Category, Integer> pointAssignment;

    /**
     *
     * Creates a new option with the text and the map of assignment of points to categories
     *
     * @param text the text of the option and identifier
     * @param pointAssignment the map of categories which receive points if this option is chosen
     */
    public Option(String text, Map<Category, Integer> pointAssignment) {
        this.text = text;
        this.pointAssignment = pointAssignment;
    }

    /**
     *
     * Returns the text for the option.
     *
     *
     * @return the option text
     */
    public String getText() {
        return text;
    }

    /**
     *
     * Returns the point assignment map, of which Categories receive points if the option is selected.
     *
     * @return
     */
    public Map<Category, Integer> getPointAssignment() {
        return new HashMap<>(pointAssignment);
    }

    @Override
    public String toString() {
        return "Option{" +
                "text='" + text + '\'' +
                '}';
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
