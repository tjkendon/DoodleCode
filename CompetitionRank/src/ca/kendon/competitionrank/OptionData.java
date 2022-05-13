package ca.kendon.competitionrank;

public class OptionData {

    private int count = 0;
    private int totalVotes = 0;
    private double averageRank = 0.0;
    private int timesGood = 0;

    public void updateCount(int votes, int rank, boolean good) {
        count++;
        totalVotes += votes;
        averageRank = ((averageRank * (count - 1)) + rank) / count;
        timesGood += good ? 1 : 0;


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

    public int getTimesGood() {
        return timesGood;
    }

    public double getGoodRate() {
        return (double) timesGood / (double) count;
    }

    public double getAverageVotes() {
        return (double) totalVotes / (double)  count;
    }

    public double getRankQualityScore() {return ((4-averageRank) * getGoodRate()) / (double) 3; }

    @Override
    public String toString() {
        return "OptionData{" +
                "count=" + count +
                ", averageVotes=" + getAverageVotes()  +
                ", averageRank=" + getAverageRank()  +
                ", goodRate=" + getGoodRate()  +
                ", rankQualityScore=" + getRankQualityScore()  +
                '}';
    }
}
