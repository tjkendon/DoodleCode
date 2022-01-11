package ca.kendon.list_difference;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ListDifference {

    private Set<String> a;
    private Set<String> b;

    /**
     *
     * Creates a new ListDifference from the two given collections.
     *
     * @param a
     * @param b
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
     * Returns the percentage of how similar A and B are
     *
     * @return the ratio of the size of the intersection out of the size of the union
     */
    public double similarity() {
        return (double)intersection().size() / (double)union().size();
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
