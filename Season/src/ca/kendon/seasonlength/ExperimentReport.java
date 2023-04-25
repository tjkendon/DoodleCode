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

    public int getTotalCompetitors() {
        return competitors.size();
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

    public String getId() {
        return id;
    }

    public List<Competitor> getCompetitors() {
        return competitors;
    }

    public List<Event> getEvents() {
        return events;
    }

    private String getCompetitorsString() {
        StringBuilder s = new StringBuilder();
        for (Competitor c: competitors) {
            s.append(String.format("\t %s %n",c.getName()));
        }
        return s.toString();
    }

    public String getReportString() {

        return String.format("Experiment %s%n%s Competitors%n%s%n" ,
                id,
                getTotalCompetitors(),
                getCompetitorsString()
                );


    }
}
