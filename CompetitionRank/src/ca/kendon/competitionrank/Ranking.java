package ca.kendon.competitionrank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ranking {

    public void generateRanking(List<CompetitionRound> rounds) {

        Map<Option, OptionData> data = new HashMap<>();

        for (CompetitionRound r : rounds) {
            for (Option o : r.getOptions()) {
                if (!data.containsKey(o)) {
                    data.put(o, null);
                }
                System.out.println(data);
            }
            System.out.println();
        }



    }



}
