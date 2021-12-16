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
    public Collection<String> getOnlyInA() {
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
    public Collection<String> getOnlyInB() {
        Set<String> resultSet = new HashSet<>(b);
        resultSet.removeAll(a);
        return resultSet;
    }

}
