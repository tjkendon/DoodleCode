package ca.kendon.competitionrank;

public class OptionData {

    private int count = 0;
    private int totalVotes = 0;
    private double averageRank = 0.0;

    public void updateCount(int votes, int rank) {
        count++;
        totalVotes += votes;
        averageRank = ((averageRank * (count - 1)) + rank) / count;


    }

    public int getCount() {
        return count;
    }

    public int getTotalVotes() {
        return totalVotes;
    }

    public double getAverageRank() {
        return averageRank;
    }

    public double getAverageVotes() {
        return (double) totalVotes / (double)  count;
    }

    @Override
    public String toString() {
        return "OptionData{" +
                "count=" + count +
                ", averageVotes=" + getAverageVotes()  +
                ", averageRank=" + getAverageRank()  +
                '}';
    }
}
