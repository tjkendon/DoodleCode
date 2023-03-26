package ca.kendon.seasonlength;

import java.util.Collection;
import java.util.List;

public interface CompetitionModel {

    Collection<Record> compete(List<Competitor> competitorList);

}
