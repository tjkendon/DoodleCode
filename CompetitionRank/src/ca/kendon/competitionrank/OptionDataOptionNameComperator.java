package ca.kendon.competitionrank;

import java.util.Comparator;

public class OptionDataOptionNameComperator implements Comparator<OptionData> {

    @Override
    public int compare(OptionData o1, OptionData o2) {
        return o1.getOption().getName().compareTo(o2.getOption().getName());
    }
}
