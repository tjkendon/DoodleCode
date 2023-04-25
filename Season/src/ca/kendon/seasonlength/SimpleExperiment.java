package ca.kendon.seasonlength;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class SimpleExperiment implements Experiment {

    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    private String id;

    private List<Competitor> competitorList;
    private PointModel pointMode;
    private CompetitionModel competitionModel;

    ExperimentReport report;

    public SimpleExperiment(
            List<Competitor> competitorList,
            PointModel pointMode,
            CompetitionModel competitionModel) {
        this.competitorList = competitorList;
        this.pointMode = pointMode;
        this.competitionModel = competitionModel;
        this.id = "SimpleExperiment" + dtf.format(LocalDateTime.now());
    }

    @Override
    public void run() {
        Season s = new Season(competitorList, competitionModel, pointMode);
        s.compete();
        Collection<Record> results = s.getResults();
        report = new ExperimentReport(id, competitorList, s.getEvents());
    }

    @Override
    public ExperimentReport getReport() {
        return report;
    }
}
