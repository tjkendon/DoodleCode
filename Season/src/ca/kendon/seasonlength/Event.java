package ca.kendon.seasonlength;

public class Event {

    Competitor a;
    Competitor b;

    double aScore;
    double bScore;

    public Event(Competitor a, Competitor b, double aScore, double bScore) {
        this.a = a;
        this.b = b;
        this.aScore = aScore;
        this.bScore = bScore;
    }

    public Competitor getCompetitorA() {
        return a;
    }

    public Competitor getCompetitorB() {
        return b;
    }

    public double getScoreA() {
        return aScore;
    }

    public double getScoreB() {
        return bScore;
    }

    public String toString() {
        return "[" + a.getName() + " - " + b.getName() + ", " + aScore + " - " + bScore + "]";
    }
}
