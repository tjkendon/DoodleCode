package ca.kendon.competitionrank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ranking {

    public void generateRanking(List<CompetitionRound> rounds, Option defaultOption) {

        Map<Option, OptionData> data = new HashMap<>();

        for (CompetitionRound r : rounds) {
            int defaultRank = r.getRank(defaultOption);
            for (Option o : r.getOptions()) {
                if (!o.equals(defaultOption)) {
                    if (!data.containsKey(o)) {
                        data.put(o, new OptionData());
                    }
                    data.get(o).updateCount(r.getVotes(o), r.getRank(o), r.getRank(o) < defaultRank);
                }
                System.out.println(data);
            }
            System.out.println();
        }



    }



}
