package ca.kendon.competitionrank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ballot {

    private Map<Option, Integer> options;

    public void putOption(Option o, int count) {
        options.put(o, count);
    }

    public Map<Option, Integer> getOptions() {
        return options;
    }
}
