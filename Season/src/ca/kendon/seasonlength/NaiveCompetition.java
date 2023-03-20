package ca.kendon.seasonlength;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NaiveCompetition implements CompetitionModel{

    Random random = new Random();

    public List<Record> compete (List<Competitor> competitorList) {

        List<Record> records = new ArrayList<>();

        for (Competitor c: competitorList) {
            Record r = new Record(c);
            for (Competitor d: competitorList) {
                if (!d.equals(c)) {
                    System.out.println(c + " vs " + d);
                    double cScore = random.nextDouble() * c.getTrueStrength();
                    double dScore = random.nextDouble() * d.getTrueStrength();

                    if (cScore < dScore) {
                        System.out.println(c + " looses");
                        r.addLoss();
                    } else {
                        System.out.println(c + " wins");
                        r.addWin();
                    }
                }
            }
            records.add(r);
        }

        return records;
    }

}
