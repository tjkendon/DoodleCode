package ca.kendon.seasonlength;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Generator for a consistant list of competitors
 *
 */
public class SimpleCompetitorListGenerator implements CompetetorDataGenerator{

    /* List size limits. */
    private static final int MAX_COMPETITORS = 5;
    private static final int MIN_COMPETITORS = 1;

    /* Actual number of competitors to be generated.*/
    private final int length;

    /**
     * Creates a generator which will create the given number of competitors.
     * @param numberOfCompetitors the number of competitors to construct.
     */
    public SimpleCompetitorListGenerator(int numberOfCompetitors) {
        if ((numberOfCompetitors > MAX_COMPETITORS) || (numberOfCompetitors < MIN_COMPETITORS)) {
            throw new IllegalArgumentException("number of Competitors must be from " + MIN_COMPETITORS
                    + " - " + MAX_COMPETITORS);
        }
        this.length = numberOfCompetitors;

    }


    /**
     *
     * Returns the list of competitors unique names and true strengths.
     *
     * @return a list of competitors with unique names and true strengths.
     */
    @Override
    public List<Competitor> getCompetitors() {

        // each competitor gets a name with a single capital letter starting at A;
        char next = 'A';
        // each competitor gets a strength, and each is roughly 1/nth stronger, but cut in half so that the strongest
        // team isn't unreasonably strong vs the weakest.
        double step = (1 / (double)length) / 2;
        // initial strength is double the step then it will go up by one step each time.
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
