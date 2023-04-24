package ca.kendon.seasonlength;

import java.util.*;

public class NaiveCompetition implements CompetitionModel {

    Random random = new Random();

    public Collection<Record> compete(List<Competitor> competitorList) {

        Map<Competitor, Record> records = new HashMap<>();
        for (Competitor c : competitorList) {
            records.put(c, new Record(c));
        }

        for (int i = 0; i < competitorList.size(); i++) {
            Competitor c = competitorList.get(i);
            Record rC = records.get(c);
            for (int j = i + 1; j < competitorList.size(); j++) {
                Competitor d = competitorList.get(j);
                Record rD = records.get(d);

                double cScore = random.nextDouble() * c.getTrueStrength();
                double dScore = random.nextDouble() * d.getTrueStrength();

                if (cScore < dScore) {
                    rC.addLoss();
                    rD.addWin();
                } else {
                    rC.addWin();
                    rD.addLoss();
                }

            }
        }

        return records.values();
    }

}
