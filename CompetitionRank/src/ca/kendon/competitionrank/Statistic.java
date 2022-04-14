package ca.kendon.competitionrank;

import java.util.List;

public class Statistic {

    private Option option;
    private int votes;
    private int rank;
    private boolean aboveDefault;

    public Statistic(Option option, int votes, int rank, boolean aboveDefault) {
        this.option = option;
        this.votes = votes;
        this.rank = rank;
        this.aboveDefault = aboveDefault;
    }

    public Option getOption() {
        return option;
    }

    public int getVotes() {
        return votes;
    }

    public int getRank() {
        return rank;
    }

    public boolean isAboveDefault() {
        return aboveDefault;
    }
}
