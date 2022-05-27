package ca.kendon.competitionrank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OptionData {

    private Option option;

    private int count = 0;
    private int totalVotes = 0;
    private double averageRank = 0.0;
    private int timesGood = 0;

    private Map<Option, Integer> wonAgainst = new HashMap<>();
    private Map<Option, Integer> lostTo = new HashMap<>();

    public OptionData(Option option) {
        this.option = option;
    }

    public void updateCount(int votes, int rank, boolean good, List<Option> wonAgainst, List<Option> lostTo) {
        count++;
        totalVotes += votes;
        averageRank = ((averageRank * (count - 1)) + rank) / count;
        timesGood += good ? 1 : 0;

        mapCount(this.wonAgainst, wonAgainst);
        mapCount(this.lostTo, lostTo);


    }

    private void mapCount(Map<Option, Integer> map, List<Option> newStuff) {
        for (Option o : newStuff) {
            if (!map.containsKey(o)) {
                map.put(o, 0);
            }
            map.put(o, map.get(o) + 1);
        }
    }


    public int getCount() {
        return count;
    }

    public Option getOption() {
        return option;
    }

    public int getTimesGood() {
        return timesGood;
    }

    public double getGoodRate() {
        return (double) timesGood / (double) count;
    }

    public double getAverageVotes() {
        return (double) totalVotes / (double) count;
    }

    public double getAverageRank() {
        return averageRank;
    }

    public double getPowerRank() {
        return ((getAverageVotes() / getAverageRank()) * getGoodRate());
    }

    @Override
    public String toString() {
        return "OptionData-" + option + "{" +
                "count=" + getCount() +
                ", averageVotes=" + getAverageVotes() +
                ", averageRank=" + getAverageRank() +
                ", goodRate=" + getGoodRate() +
                ", powerRank=" + getPowerRank() +
                '}';
    }


}

