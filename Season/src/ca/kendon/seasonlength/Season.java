package ca.kendon.seasonlength;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

public class Season {

    private List<Competitor> competitors;
    private Collection<Record> results;

    private CompetitionModel model;

    public Season(List<Competitor> competitors, CompetitionModel model) {
        this.competitors = competitors;
        this.model = model;
    }

    public List<Competitor> getCompetitors() {
        return competitors;
    }

    public Collection<Record> getResults() {
        return results;
    }

    public void compete() {
        results = model.compete(competitors);
    }


}
