package ca.kendon.competitionrank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ballot {

    private Map<Option, Integer> options;

    public Ballot (List<Option> options) {
        this.options = new HashMap<>();
        for (Option o : options) {
            this.options.put(o, 0);
        }
    }



}
