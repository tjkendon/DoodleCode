package ca.kendon.list_difference;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ListDifference {

    private final Set<String> a;
    private final Set<String> b;

    /**
     *
     * Creates a new ListDifference from the two given collections.
     *
     * @param a the first set of strings
     * @param b the second set of strings
     */
    public ListDifference(Collection<String> a, Collection<String> b) {

        this.a = new HashSet<>(a);
        this.b = new HashSet<>(b);

    }

    /**
     *
     * Returns a collection of only those strings found in A.
     *
     * @return a set of those only in A
     */
    public Set<String> onlyInA() {
        Set<String> resultSet = new HashSet<>(a);
        resultSet.removeAll(b);
        return resultSet;
    }

    /**
     *
     * Returns a collection of only those strings found in B.
     *
     * @return a set of those only in B
     */
    public Set<String> onlyInB() {
        Set<String> resultSet = new HashSet<>(b);
        resultSet.removeAll(a);
        return resultSet;
    }

    /**
     *
     * Returns the union of A and B.
     *
     * @return a set of everything in A and everything in B
     */
    public Set<String> union() {
        Set<String> fullSet = new HashSet<>(a);
        fullSet.addAll(b);
        return fullSet;
    }

    /**
     *
     * Returns the intersection of A and B
     *
     * @return a set of everything found in both A and B
     */
    public Set<String> intersection() {
        Set<String> resultSet = union();
        resultSet.removeAll(onlyInA());
        resultSet.removeAll(onlyInB());
        return resultSet;
    }

    /**
     *
     * Returns the percentage of strings which are uniquely found in A
     *
     * @return the percent of elements only in A (out of the size of the union)
     */
    public double percentInA() {
        return ((double)onlyInA().size() / (double)union().size());
    }

    /**
     *
     Returns the percentage of strings which are uniquely found in B
     *
     * @return the percent of elements only in B (out of the size of the union)
     */
    public double percentInB() {
        return ((double)onlyInB().size() / (double)union().size());
    }

    /**
     *
     * Returns the Jaccard Similarity measure of how similar A and B are
     *
     * @return the ratio of the size of the intersection out of the size of the union
     */
    public double jaccardSimilarity() {
        return (double)intersection().size() / (double)union().size();
    }

    /**
     *
     * Returns the S&oslash;rensen&ndash;Dice coefficient measure of how similar A and B are
     *
     * @return the ratio of twice the size of the intersection out of the sum of the sizes of a and b
     */
    public double sdSimilarity() {
        return ((double) intersection().size() * 2) / (double) (a.size() + b.size());
    }

    /**
     *
     * Returns the Szymkiewicz–Simpson coefficient measure of how similar A and B are
     *
     * @return the ratio of the intersection size out of the lesser of the size of a and b
     */
    public double overlapSimilarity() {
        return (double)intersection().size() / (double) Math.min(a.size(), b.size());
    }

    /**
     *
     * Returns everything in A
     *
     * @return A
     */
    public Set<String> getA() {
        return a;
    }

    /**
     *
     * Returns everything in B
     *
     * @return B
     */
    public Set<String> getB() {
        return b;
    }
}
