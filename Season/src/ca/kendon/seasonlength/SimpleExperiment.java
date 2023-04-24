package ca.kendon.seasonlength;

import java.util.List;

public class SimpleExperiment implements Experiment {

    List<Competitor> competitorList;

    public SimpleExperiment(List<Competitor> competitorList) {
        this.competitorList = competitorList;
    }


}
