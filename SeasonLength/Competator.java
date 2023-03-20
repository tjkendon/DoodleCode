public class Competator {

    private String name;
    private double trueStrength;

    public Competator(String name, double strength) {
        this.name = name;
        this.trueStrength = strength;
    }

    public String getName() {
        return name;
    }

    public double getTrueStrength() {
        return trueStrength;
    }
}
