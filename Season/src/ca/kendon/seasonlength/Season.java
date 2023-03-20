package ca.kendon.seasonlength;

import java.util.List;
import java.util.ArrayList;

public abstract class Season {

    private List<Competitor> competitors;
    private List<Record> results;

    private CompetitionModel model;

    public Season(List<Competitor> competitors) {
        this.competitors = competitors;
    }

    public List<Competitor> getCompetitors() {
        return competitors;
    }

    public List<Record> getResults() {
        return results;
    }

    public void compete() {
        results = model.compete();
    }


}
