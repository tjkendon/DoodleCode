package ca.kendon.competitionrank;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        Map<Integer, List<Option>> expected = new HashMap<>();
        List<Option> listA = new ArrayList<>();
        listA.add(a);
        expected.put(1, listA);
        List<Option> listB = new ArrayList<>();
        listB.add(b);
        expected.put(2, listB);
        List<Option> listC = new ArrayList<>();
        listC.add(c);
        expected.put(3, listC);
        List<Option> listD = new ArrayList<>();
        listD.add(d);
        expected.put(4, listD);

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

        Map<Integer, List<Option>> expected = new HashMap<>();
        List<Option> listA = new ArrayList<>();
        listA.add(a);
        listA.add(b);
        listA.add(c);
        listA.add(d);
        expected.put(1, listA);


        assertEquals(expected, test.getRanked(), "Testing four options all tied");

    }

}