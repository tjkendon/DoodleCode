package ca.kendon.competitionrank;

import java.util.*;


public class Ranking {

    private Option defaultOption;
    private Map<Option, OptionData> data = new HashMap<>();

    public Ranking(Option defaultOption) {
        this.defaultOption = defaultOption;
    }

    protected void rankOptions(List<CompetitionRound> rounds) {

        for (CompetitionRound r : rounds) {
            int defaultRank = r.getRank(defaultOption);
            for (Option o : r.getOptions()) {
                if (!o.equals(defaultOption)) {
                    if (!data.containsKey(o)) {
                        data.put(o, new OptionData(o));
                    }
                    data.get(o).updateCount(
                            r.getVotes(o),
                            r.getRank(o),
                            r.getRank(o) < defaultRank,
                            r.getBetterThan(o),
                            r.getWorseThan(o));
                }
            }
        }

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


    public Map<Option, OptionData> getData() {
        return data;
    }
}
