package ca.kendon.seasonlength;

import java.util.ArrayList;
import java.util.List;

public class SimpleCompetitorListGenerator implements CompetetorDataGenerator{

    private static final int MAX_COMPETITORS = 5;
    private static final int MIN_COMPETITORS = 1;

    private final int length;

    public SimpleCompetitorListGenerator(int numberOfCompetitors) {
        if ((numberOfCompetitors > MAX_COMPETITORS) || (numberOfCompetitors < MIN_COMPETITORS)) {
            throw new IllegalArgumentException("number of Competitors must be from " + MIN_COMPETITORS
                    + " - " + MAX_COMPETITORS);
        }
        this.length = numberOfCompetitors;

    }


    @Override
    public List<Competitor> getCompetitors() {

        char next = 'A';
        double step = (1 / (double)length) / 2;
        double strength = step * 2;

        List<Competitor> competitors = new ArrayList<>();

        for (int i = length; i > 0; i--) {
            Competitor competitor = new Competitor("" + next, strength);
            competitors.add(competitor);

            next++;
            strength+=step;
        }

        return competitors;
    }
}
