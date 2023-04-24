package ca.kendon.seasonlength;

import java.util.Collection;
import java.util.List;

public class Season {

    private List<Competitor> competitors;
    private Collection<Record> results;

    private PointModel pointModel;

    private CompetitionModel competitionModel;

    public Season(List<Competitor> competitors, CompetitionModel cModel, PointModel pointModel) {
        this.competitors = competitors;
        this.competitionModel = cModel;
        this.pointModel = pointModel;
    }

    public Collection<Record> getResults() {
        return results;
    }

    public PointModel getPointModel() {
        return pointModel;
    }

    public CompetitionModel getCompetitionModel() {
        return competitionModel;
    }

    public void compete() {
        results = competitionModel.compete(competitors);
    }


    public List<Event> getEvents() {
        return competitionModel.getEvents();
    }
}
