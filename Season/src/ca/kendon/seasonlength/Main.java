package ca.kendon.seasonlength;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        System.out.println("Test Season");

        Competitor cA = new Competitor("A", 0.5);
        Competitor cB = new Competitor("B", 0.3);
        Competitor cC = new Competitor("C", 0.8);

        List<Competitor> competitors = new ArrayList<>();
        competitors.add(cA);
        competitors.add(cB);
        competitors.add(cC);

        Season s = new Season(competitors, new NaiveCompetition());
        s.compete();
        List<Record> results = s.getResults();
        System.out.println(results);

    }
}
