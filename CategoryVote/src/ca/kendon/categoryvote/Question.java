package ca.kendon.categoryvote;

import java.util.List;

/**
 *
 * A question, including the options to answer that question
 *
 */

public class Question {

    /**
     * Short display name for the question, used as the identifier
     */
    private final String name;
    /**
     * The text of the question
     */
    private final String stem;
    /**
     * The list of options
     */
    private final List<Option> options;


    /**
     *
     * Creates a new question.
     *
     * @param name a short identifier for the question
     * @param stem the main text of the question
     * @param options the possible answers to the question
     */
    public Question(String name, String stem, List<Option> options) {
        this.name = name;
        this.stem = stem;
        this.options = options;
    }

    /**
     *
     * The identifier for the question
     *
     * @return the identifying name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * The text of the question
     *
     * @return the question text
     */
    public String getStem() {
        return stem;
    }

    /**
     *
     * The possible answers to the question
     *
     * @return the possible answers to the question
     */
    public List<Option> getOptions() {
        return options;
    }

    @Override
    public String toString() {
        return "Question{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        if (name != null ? !name.equals(question.name) : question.name != null) return false;
        if (stem != null ? !stem.equals(question.stem) : question.stem != null) return false;
        return options != null ? options.equals(question.options) : question.options == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (stem != null ? stem.hashCode() : 0);
        result = 31 * result + (options != null ? options.hashCode() : 0);
        return result;
    }
}
