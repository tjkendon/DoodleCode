package ca.kendon.seasonlength;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExperimentReport {

    String id;
    List<Competitor> competitors;
    List<Event> events;

    public ExperimentReport(String id, List<Competitor> competitors, List<Event> events) {
        this.id = id;
        this.competitors = competitors;
        this.events = events;
    }

    public int getTotalCompetitions() {
        return events.size();
    }

    public Map<Competitor, List<Event>> getAllCompetitorEvents() {
        HashMap<Competitor, List<Event>> eventMap = new HashMap<>();
        for (Competitor c: competitors) {
            List<Event> competitorEvents = new ArrayList<>();
            for (Event e: events) {
                if (e.playedIn(c)) {
                    competitorEvents.add(e);
                }
            }
            eventMap.put(c, competitorEvents);
        }
        return  eventMap;

    }

    public String getReportString() {

        return String.format("Experiment %s", id);

    }
}
