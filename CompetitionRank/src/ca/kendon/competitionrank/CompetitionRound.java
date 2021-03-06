package ca.kendon.competitionrank;

import java.util.*;

public class CompetitionRound {

    private String name;

    private Map<Option, Integer> options;
    private Map<Integer, Set<Option>> ranked;

    public CompetitionRound () {
        this.name = "Unnamed";
        options = new HashMap<>();
        ranked = null;
    }

    public CompetitionRound (String name) {
        this.name = name;
        options = new HashMap<>();
        ranked = null;
    }

    public void putOption(Option o, int votes) {
        options.put(o, votes);
        ranked = null;
    }

    public String getName() {
        return name;
    }

    public Set<Option> getOptions() {
        return options.keySet();
    }

    public Map<Option, Integer> getOptionVotes() {
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
            if ((ranked.get(i) != null) && ranked.get(i).contains(o)) {
                return i;
            }
        }
        return Integer.MAX_VALUE;
    }

    protected Map<Integer, Set<Option>> getRanked() {
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
            HashSet<Option> pullOptions = new HashSet<>();
            for (Map.Entry<Option, Integer> e : allOptions.entrySet()) {
                if (e.getValue() == max) {
                    pullOptions.add(e.getKey());
                }
                if (e.getValue() > max) {
                    max = e.getValue();
                    pullOptions = new HashSet<>();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompetitionRound that = (CompetitionRound) o;

        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        return getOptionVotes() != null ? getOptionVotes().equals(that.getOptionVotes()) : that.getOptionVotes() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getOptionVotes() != null ? getOptionVotes().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return name + " - " + options + " - " + getRanked();

    }


    public List<Option> getBetterThan(Option option) {
        if(options.containsKey(option)) {
            List<Option> betterThan = new ArrayList<>();
            for (Option o : options.keySet()) {
                if (options.get(option) > options.get(o)) {
                    betterThan.add(o);
                }
            }
            return betterThan;
         }
        return null;
    }

    public List<Option> getWorseThan(Option option) {
        if(options.containsKey(option)) {
            List<Option> worseThan = new ArrayList<>();
            for (Option o : options.keySet()) {
                if (options.get(option) < options.get(o)) {
                    worseThan.add(o);
                }
            }
            return worseThan;
        }
        return null;
    }
}
