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

    @Test
    void testRankingTwoTwoWayTies() {
        Option a = new Option("Course A");
        Option b = new Option("Course B");
        Option c = new Option("Course C");
        Option d = new Option("Course D");

        CompetitionRound test = new CompetitionRound();
        test.putOption(a, 4);
        test.putOption(b, 4);
        test.putOption(c, 2);
        test.putOption(d, 2);

        Map<Integer, Set<Option>> expected = new HashMap<>();
        Set<Option> setA = new HashSet<>();
        setA.add(a);
        setA.add(b);
        expected.put(1, setA);
        Set<Option> setB = new HashSet<>();
        setB.add(c);
        setB.add(d);
        expected.put(3, setB);


        assertEquals(expected, test.getRanked(), "Testing two two way ties");

    }

    @Test
    void testRankingOneAndThreeWayTie() {
        Option a = new Option("Course A");
        Option b = new Option("Course B");
        Option c = new Option("Course C");
        Option d = new Option("Course D");

        CompetitionRound test = new CompetitionRound();
        test.putOption(a, 4);
        test.putOption(b, 4);
        test.putOption(c, 4);
        test.putOption(d, 0);

        Map<Integer, Set<Option>> expected = new HashMap<>();
        Set<Option> setA = new HashSet<>();
        setA.add(a);
        setA.add(b);
        setA.add(c);
        expected.put(1, setA);
        Set<Option> setB = new HashSet<>();
        setB.add(d);
        expected.put(4, setB);

        assertEquals(expected, test.getRanked(), "Testing one then a three way tie");

    }

    @Test
    void testRankingThreeWayTieAndOne() {
        Option a = new Option("Course A");
        Option b = new Option("Course B");
        Option c = new Option("Course C");
        Option d = new Option("Course D");

        CompetitionRound test = new CompetitionRound();
        test.putOption(a, 1);
        test.putOption(b, 1);
        test.putOption(c, 1);
        test.putOption(d, 6);

        Map<Integer, Set<Option>> expected = new HashMap<>();
        Set<Option> setA = new HashSet<>();
        setA.add(a);
        setA.add(b);
        setA.add(c);
        expected.put(2, setA);
        Set<Option> setB = new HashSet<>();
        setB.add(d);
        expected.put(1, setB);

        assertEquals(expected, test.getRanked(), "Testing three way tie then one");

    }

    @Test
    void testRankingOneOneTwo() {
        Option a = new Option("Course A");
        Option b = new Option("Course B");
        Option c = new Option("Course C");
        Option d = new Option("Course D");

        CompetitionRound test = new CompetitionRound();
        test.putOption(a, 6);
        test.putOption(b, 4);
        test.putOption(c, 1);
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
        setC.add(d);
        expected.put(3, setC);

        assertEquals(expected, test.getRanked(), "Testing one, one, then two");

    }

    @Test
    void testRankingOneTwoOne() {
        Option a = new Option("Course A");
        Option b = new Option("Course B");
        Option c = new Option("Course C");
        Option d = new Option("Course D");

        CompetitionRound test = new CompetitionRound();
        test.putOption(a, 6);
        test.putOption(b, 2);
        test.putOption(c, 2);
        test.putOption(d, 1);

        Map<Integer, Set<Option>> expected = new HashMap<>();
        Set<Option> setA = new HashSet<>();
        setA.add(a);
        expected.put(1, setA);
        Set<Option> setB = new HashSet<>();
        setB.add(b);
        setB.add(c);
        expected.put(2, setB);
        Set<Option> setC = new HashSet<>();
        setC.add(d);
        expected.put(4, setC);

        assertEquals(expected, test.getRanked(), "Testing one, two, then one");

    }

    @Test
    void testRankingTwoOneOne() {
        Option a = new Option("Course A");
        Option b = new Option("Course B");
        Option c = new Option("Course C");
        Option d = new Option("Course D");

        CompetitionRound test = new CompetitionRound();
        test.putOption(a, 3);
        test.putOption(b, 3);
        test.putOption(c, 2);
        test.putOption(d, 1);

        Map<Integer, Set<Option>> expected = new HashMap<>();
        Set<Option> setA = new HashSet<>();
        setA.add(a);
        setA.add(b);
        expected.put(1, setA);
        Set<Option> setB = new HashSet<>();
        setB.add(c);
        expected.put(3, setB);
        Set<Option> setC = new HashSet<>();
        setC.add(d);
        expected.put(4, setC);

        assertEquals(expected, test.getRanked(), "Testing one, two, then one");

    }

    @Test
    void testGetRank4Ranks() {
        Option a = new Option("Course A");
        Option b = new Option("Course B");
        Option c = new Option("Course C");
        Option d = new Option("Course D");

        CompetitionRound test = new CompetitionRound();
        test.putOption(a, 6);
        test.putOption(b, 3);
        test.putOption(c, 2);
        test.putOption(d, 1);

        assertEquals(1, test.getRank(a), "Testing getRank - 1 - 4 ranks");
        assertEquals(2, test.getRank(b), "Testing getRank - 2 - 4 ranks");
        assertEquals(3, test.getRank(c), "Testing getRank - 3 - 4 ranks");
        assertEquals(4, test.getRank(d), "Testing getRank - 4 - 4 ranks");


    }

    @Test
    void testGetRank3Ranks112() {
        Option a = new Option("Course A");
        Option b = new Option("Course B");
        Option c = new Option("Course C");
        Option d = new Option("Course D");

        CompetitionRound test = new CompetitionRound();
        test.putOption(a, 6);
        test.putOption(b, 3);
        test.putOption(c, 1);
        test.putOption(d, 1);

        assertEquals(1, test.getRank(a), "Testing getRank - a=1 - 3 ranks");
        assertEquals(2, test.getRank(b), "Testing getRank - a=2 - 3 ranks");
        assertEquals(3, test.getRank(c), "Testing getRank - a=3 - 3 ranks");
        assertEquals(3, test.getRank(d), "Testing getRank - a=3 - 3 ranks");

    }

    @Test
    void testGetRank3Ranks211() {
        Option a = new Option("Course A");
        Option b = new Option("Course B");
        Option c = new Option("Course C");
        Option d = new Option("Course D");

        CompetitionRound test = new CompetitionRound();
        test.putOption(a, 6);
        test.putOption(b, 6);
        test.putOption(c, 3);
        test.putOption(d, 1);

        assertEquals(1, test.getRank(a), "Testing getRank - a=1 - 3 ranks");
        assertEquals(1, test.getRank(b), "Testing getRank - b=1 - 3 ranks");
        assertEquals(3, test.getRank(c), "Testing getRank - c=3 - 3 ranks");
        assertEquals(4, test.getRank(d), "Testing getRank - d=4 - 3 ranks");

    }

    @Test
    void testGetRank3Ranks121() {
        Option a = new Option("Course A");
        Option b = new Option("Course B");
        Option c = new Option("Course C");
        Option d = new Option("Course D");

        CompetitionRound test = new CompetitionRound();
        test.putOption(a, 6);
        test.putOption(b, 6);
        test.putOption(c, 3);
        test.putOption(d, 1);

        assertEquals(1, test.getRank(a), "Testing getRank - a=1 - 3 ranks");
        assertEquals(1, test.getRank(b), "Testing getRank - b=1 - 3 ranks");
        assertEquals(3, test.getRank(c), "Testing getRank - c=3 - 3 ranks");
        assertEquals(4, test.getRank(d), "Testing getRank - d=4 - 3 ranks");

    }

}