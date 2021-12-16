package ca.kendon.list_difference;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ListDifference {

    Set<String> setA;
    Set<String> setB;

    /**
     *
     * Creates a new ListDifference from the two given collections.
     *
     * @param listA
     * @param listB
     */
    public ListDifference(Collection<String> listA, Collection<String> listB) {

        this.setA = new HashSet<>(listA);
        this.setB = new HashSet<>(listB);

    }

}
