package ca.kendon.list_difference;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ListDifference {

    Set<String> a;
    Set<String> b;

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
     * @return
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
     * @return
     */
    public Set<String> onlyInB() {
        Set<String> resultSet = new HashSet<>(b);
        resultSet.removeAll(a);
        return resultSet;
    }

    public Set<String> union() {
        Set<String> fullSet = new HashSet<>(a);
        fullSet.addAll(b);
        return fullSet;
    }

    public double percentInA() {
        return ((double)onlyInA().size() / (double)union().size());
    }

    public double percentInB() {
        return ((double)onlyInB().size() / (double)union().size());
    }

    public Set<String> intersection() {
        Set<String> resultSet = union();
        resultSet.removeAll(onlyInA());
        resultSet.removeAll(onlyInB());
        return resultSet;
    }

    public double similarity() {
        return (double)intersection().size() / (double)union().size();
    }

}
