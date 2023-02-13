package ca.kendon.competitionrank;

import java.util.*;


public class Ranking {

    private final Option defaultOption;
    private final Map<Option, OptionData> data = new HashMap<>();

    public Ranking(Option defaultOption) {
        this.defaultOption = defaultOption;
    }

    protected void rankOptions(List<CompetitionRound> rounds) {

        for (CompetitionRound r : rounds) {
            for (Option o : r.getOptions()) {
                if (!o.equals(defaultOption)) {
                    if (!data.containsKey(o)) {
                        data.put(o, new OptionData(o));
                    }
                    data.get(o).updateCount(
                            r.getVotes(o),
                            r.getRank(o),
                            r.getBetterThan(o),
                            r.getWorseThan(o));
                }
            }
        }

    }

    public Map<Option, Integer> getQualityOfCompetition() {

        Map<Option, Double> qualityOfCompetition = new HashMap<>();
        for (Option o: data.keySet()) {
            double score = 0;
            for (Option c: data.get(o).getWonAgainst().keySet()) {
                if (!c.equals(defaultOption)) {
                    score += data.get(c).getOverallWinRate();
                }
            }
            System.out.println(o.getName() + "," + score);
            qualityOfCompetition.put(o, score / (data.get(o).getWonAgainst().size() + data.get(o).getLostTo().size()));
        }


        return null;
    }

    public List<Option> optionsBySort(Comparator<OptionData> comparator) {
        List<OptionData> values =  new ArrayList<>(data.values());
        Collections.sort(values,comparator);
        List<Option> results = new ArrayList<>();
        for (OptionData od: values) {
            results.add(od.getOption());
        }
        return results;
    }

    public OptionData getOptionData(String key) {
        for (Option o: data.keySet()) {
            if (o.getName().equals(key)) {
                return data.get(o);
            }
        }
        return null;
    }


    public Map<Option, OptionData> getData() {
        return data;
    }
}
