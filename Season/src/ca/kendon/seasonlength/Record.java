package ca.kendon.seasonlength;



public class Record {

    private Competitor competitor;
    int wins;
    int overtimeWins;
    int losses;
    int overtimeLosses;
    int ties;

    public Record(Competitor competitor) {
        this.competitor = competitor;
    }

    public void addWin() {
        wins++;
    }

    public void addOvertimeWin() {
        overtimeWins++;
    }

    public void addTie() {
        ties++;
    }

    public void addOvertimeLoss() {
        overtimeLosses++;
    }

    public void addLoss() {
        losses++;
    }

    public Competitor getCompetitor() {
        return competitor;
    }

    public int getWins() {
        return wins;
    }

    public int getOvertimeWins() {
        return overtimeWins;
    }

    public int getLosses() {
        return losses;
    }

    public int getOvertimeLosses() {
        return overtimeLosses;
    }

    public int getTies() {
        return ties;
    }
}
