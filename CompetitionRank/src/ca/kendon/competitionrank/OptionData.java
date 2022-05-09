package ca.kendon.competitionrank;

public class OptionData {

    private int count = 0;
    private int totalVotes = 0;

    public void updateCount(int votes) {
        count++;
        totalVotes += votes;

    }

    public int getCount() {
        return count;
    }

    public int getTotalVotes() {
        return totalVotes;
    }

    public double getAverageVotes() {
        return (double) totalVotes / (double)  count;
    }

    @Override
    public String toString() {
        return "OptionData{" +
                "count=" + count +
                ", averageVotes=" + getAverageVotes()  +
                '}';
    }
}
