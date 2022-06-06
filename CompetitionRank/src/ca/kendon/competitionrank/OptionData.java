package ca.kendon.competitionrank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OptionData {

    private final Option option;

    private int count = 0;
    private int totalVotes = 0;
    private double averageRank = 0.0;

    private final Map<Option, Integer> wonAgainst = new HashMap<>();
    private final Map<Option, Integer> lostTo = new HashMap<>();

    public OptionData(Option option) {
        this.option = option;
    }

    public void updateCount(int votes, int rank, List<Option> wonAgainst, List<Option> lostTo) {
        count++;
        totalVotes += votes;
        averageRank = ((averageRank * (count - 1)) + rank) / count;

        mapCount(this.wonAgainst, wonAgainst);
        mapCount(this.lostTo, lostTo);


    }

    private void mapCount(Map<Option, Integer> map, List<Option> newStuff) {
        for (Option o : newStuff) {
            map.putIfAbsent(o, 0);
            map.put(o, map.get(o) + 1);
        }
    }

    public int getCount() {
        return count;
    }

    public Option getOption() {
        return option;
    }

    public double getBetterRate(Option o) {
        return (double) getTimesBetterThan(o) / (double) count;
    }

    public double getAverageVotes() {
        return (double) totalVotes / (double) count;
    }

    public double getAverageRank() {
        return averageRank;
    }

    public double getPowerRank(Option defaultOption) {
        return ((getAverageVotes() / getAverageRank()) * getBetterRate(defaultOption));
    }

    public int getTimesBetterThan(Option o) {
        return wonAgainst.getOrDefault(o, 0);
    }

    @Override
    public String toString() {
        return "OptionData-" + option + "{" +
                "count=" + getCount() +
                ", averageVotes=" + getAverageVotes() +
                ", averageRank=" + getAverageRank() +
                '}';
    }


    public Map<Option, Integer> getWonAgainst() {
        return wonAgainst;
    }

    public Map<Option, Integer> getLostTo() {
        return lostTo;
    }

    public double getOverallWinRate() {
        return (double) getTotal(wonAgainst) / ((double) getTotal(lostTo) + (double) getTotal(wonAgainst));
    }

    private int getTotal(Map<Option, Integer> data) {
        int total = 0;
        for (Integer v: data.values()) {
            total += v;
        }
        return total;
    }
}

