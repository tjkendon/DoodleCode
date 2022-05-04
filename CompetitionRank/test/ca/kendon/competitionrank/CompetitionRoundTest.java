package ca.kendon.competitionrank;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CompetitionRoundTest {

    @Test
    void testRankingOneOptionPerRank() {
        // four options with different number of votes, should each be in its own rank
        Option a = new Option("Course A");
        Option b = new Option("Course B");
        Option c = new Option("Course C");
        Option d = new Option("Course D");

        CompetitionRound test = new CompetitionRound();
        test.putOption(a, 6);
        test.putOption(b, 3);
        test.putOption(c, 2);
        test.putOption(d, 1);

        Map<Integer, Set<Option>> expected = new HashMap<>();
        Set<Option> setA = new HashSet<>();
        setA.add(a);
        expected.put(1, setA);
        Set<Option> setB = new HashSet<>();
        setB.add(b);
        expected.put(2, setB);
        Set<Option> setC = new HashSet<>();
        setC.add(c);
        expected.put(3, setC);
        Set<Option> setD = new HashSet<>();
        setD.add(d);
        expected.put(4, setD);

        assertEquals(expected, test.getRanked(), "Testing four options each in their own rank");

    }

    @Test
    void testRankingFourWayTie() {
        // four options with same number of votes, all should be ranked 1
        Option a = new Option("Course A");
        Option b = new Option("Course B");
        Option c = new Option("Course C");
        Option d = new Option("Course D");

        CompetitionRound test = new CompetitionRound();
        test.putOption(a, 3);
        test.putOption(b, 3);
        test.putOption(c, 3);
        test.putOption(d, 3);

        Map<Integer, Set<Option>> expected = new HashMap<>();
        Set<Option> setA = new HashSet<>();
        setA.add(a);
        setA.add(b);
        setA.add(c);
        setA.add(d);
        expected.put(1, setA);


        assertEquals(expected, test.getRanked(), "Testing four options all tied");

    }

}