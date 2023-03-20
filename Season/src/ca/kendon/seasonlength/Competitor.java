package ca.kendon.seasonlength;

public class Competitor {

    private String name;
    private double trueStrength;

    public Competitor(String name, double trueStrength) {
        this.name = name;
        this.trueStrength = trueStrength;
    }

    public String getName() {
        return name;
    }

    public double getTrueStrength() {
        return trueStrength;
    }
}
