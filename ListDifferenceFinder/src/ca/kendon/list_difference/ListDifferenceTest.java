package ca.kendon.list_difference;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class ListDifferenceTest {

    @Test
    void onlyInA() {
        ArrayList<String> a = new ArrayList<>();
        a.add("A");
        a.add("B");
        a.add("C");
        ArrayList<String> b= new ArrayList<>();
        b.add("B");
        b.add("C");

        ListDifference diff = new ListDifference(a, b);

        Set<String> expected = new HashSet<>();
        expected.add("A");

        Set<String> result = diff.onlyInA();
        assertIterableEquals(expected, result);

    }

    @Test
    void onlyInA_noneOnlyInA() {
        ArrayList<String> a = new ArrayList<>();
        a.add("B");
        a.add("C");
        ArrayList<String> b= new ArrayList<>();
        b.add("A");
        b.add("B");
        b.add("C");

        ListDifference diff = new ListDifference(a, b);

        Set<String> expected = new HashSet<>();

        Set<String> result = diff.onlyInA();
        assertIterableEquals(expected, result);

    }



    @Test
    void onlyInB_noneOnlyInB() {
        ArrayList<String> a = new ArrayList<>();
        a.add("A");
        a.add("B");
        a.add("C");
        ArrayList<String> b= new ArrayList<>();
        b.add("B");
        b.add("C");

        ListDifference diff = new ListDifference(a, b);

        Set<String> expected = new HashSet<>();

        Set<String> result = diff.onlyInB();
        assertIterableEquals(expected, result);

    }

    @Test
    void onlyInB() {

        ArrayList<String> a = new ArrayList<>();
        a.add("B");
        a.add("C");
        ArrayList<String> b= new ArrayList<>();
        b.add("A");
        b.add("B");
        b.add("C");

        ListDifference diff = new ListDifference(a, b);

        Set<String> expected = new HashSet<>();
        expected.add("A");

        Set<String> result = diff.onlyInB();
        assertIterableEquals(expected, result);
    }

    @Test
    void union() {
    }

    @Test
    void percentInA() {
    }

    @Test
    void percentInB() {
    }

    @Test
    void intersection() {
    }

    @Test
    void similarity() {
    }
}