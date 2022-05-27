package ca.kendon.competitionrank;

import java.util.Comparator;

public class OptionDataPowerRankComparator implements Comparator<OptionData> {

    private Option defaultOption;

    public OptionDataPowerRankComparator(Option defaultOption) {
        this.defaultOption = defaultOption;
    }

    @Override
    public int compare(OptionData o1, OptionData o2) {
        return Double.compare(o2.getPowerRank(defaultOption), o1.getPowerRank(defaultOption));
    }
}
