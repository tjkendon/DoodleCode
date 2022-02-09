package ca.kendon.categoryvote;

import java.util.List;

public class Question {

    private String name;
    private String stem;
    private List<Option> options;

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
}
