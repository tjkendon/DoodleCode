package ca.kendon.seasonlength;

public class Competitor {

    /**
     * Name and primariy identifier for a competitor.
     */
    private String name;
    /**
     * The "actual" strength of the competitor.
     */
    private double trueStrength;

    /**
     *
     * Creates a new Competitor with their name and trueStrength.
     *
     * @param name name which is the  primary identifier for a competitor.
     * @param trueStrength the actual strength of the competitor.
     *                     This represents how good a team should be between 0 and 1.
     */
    public Competitor(String name, double trueStrength) {
        this.name = name;
        this.trueStrength = trueStrength;
    }

    /**
     * Returns the name, which is the primary identifier for a competitor.
     * @return name of the competitor.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the True Strength a competitor. This represents how good a team should be between 0 and 1.
     * @return true Strength of the competitor.
     */
    public double getTrueStrength() {
        return trueStrength;
    }
}
