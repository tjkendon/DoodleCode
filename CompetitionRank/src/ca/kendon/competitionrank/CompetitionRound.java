package ca.kendon.competitionrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class CompetitionRound {

    private Map<Option, Integer> options;
    private Map<Integer, List<Option>> ranked;

    public CompetitionRound () {
        options = new HashMap<>();
        ranked = null;
    }

    public void putOption(Option o, int votes) {
        options.put(o, votes);
        ranked = null;
    }

    public Map<Option, Integer> getOptions() {
        return options;
    }

    public int getVotes (Option o) {
        return options.get(o);
    }

    public int getRank(Option o) {
        if (ranked == null) {
            rankOptions();
        }
        for (int i = 1; i <= 4; i++ ) {
            if (ranked.get(i).contains(o)) {
                return i;
            }
        }
        return -1;
    }

    protected Map<Integer, List<Option>> getRanked() {
        if (ranked == null) {
            rankOptions();
        }
        return ranked;
    }

    private void rankOptions() {
        Map<Option, Integer> allOptions = new HashMap<>();
        ranked = new HashMap<>();
        allOptions.putAll(options);

        for (int i = 1; i <= 4; ) {
            int max = -1;
            ArrayList<Option> pullOptions = new ArrayList<>();
            for (Map.Entry<Option, Integer> e : allOptions.entrySet()) {
                if (e.getValue() == max) {
                    pullOptions.add(e.getKey());
                }
                if (e.getValue() > max) {
                    max = e.getValue();
                    pullOptions = new ArrayList<>();
                    pullOptions.add(e.getKey());
                }

            }
            ranked.put(i, pullOptions);
            for (Option o: pullOptions) {
                allOptions.remove(o);
            }
            i += pullOptions.size();

        }
    }





}
