package ca.kendon.categoryvote;

import java.util.List;

public class Question {

    private final String name;
    private final String stem;
    private final List<Option> options;


    public Question(String name, String stem, List<Option> options) {
        this.name = name;
        this.stem = stem;
        this.options = options;
    }

    public String getName() {
        return name;
    }

    public String getStem() {
        return stem;
    }

    public List<Option> getOptions() {
        return options;
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
