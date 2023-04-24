package ca.kendon.seasonlength;

import java.util.Collection;
import java.util.List;

public class SimpleExperiment implements Experiment {

    private List<Competitor> competitorList;
    private PointModel pointMode;
    private CompetitionModel competitionModel;

    public SimpleExperiment(
            List<Competitor> competitorList,
            PointModel pointMode,
            CompetitionModel competitionModel) {
        this.competitorList = competitorList;
        this.pointMode = pointMode;
        this.competitionModel = competitionModel;
    }

    @Override
    public void run() {
        Season s = new Season(competitorList, competitionModel, pointMode);
        s.compete();
        Collection<Record> results = s.getResults();
        System.out.println(results);
    }
}
