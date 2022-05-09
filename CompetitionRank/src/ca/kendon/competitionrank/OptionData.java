package ca.kendon.competitionrank;

public class OptionData {

    private int count = 0;


    public void updateCount() {
        count++;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "OptionData{" +
                "count=" + count +
                '}';
    }
}
