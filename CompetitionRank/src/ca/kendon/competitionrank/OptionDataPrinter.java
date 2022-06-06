package ca.kendon.competitionrank;

import java.util.Map;
import java.util.Set;

public class OptionDataPrinter {

    public static String printToString(OptionData data, Option defaultOption) {
        String returnString = String.format("%s%n\tCount: %s%n\tAverage Votes: %.3f%n\tAverage Rank: %.3f" +
                        "%n\tPower Rank: %.3f%n\tPercent Over Random: %.0f%%%n\tWin Rate: %.3f",
                data.getOption().getName(),
                data.getCount(),
                data.getAverageVotes(),
                data.getAverageRank(),
                data.getPowerRank(defaultOption),
                data.getBetterRate(defaultOption) * 100,
                data.getOverallWinRate()
        );
        returnString += String.format("%n\tWins Against (%s):", data.getWonAgainst().size());
        for( Map.Entry<Option, Integer> e: data.getWonAgainst().entrySet()) {
            returnString += " " + e.getKey() + ":" + e.getValue();
        }
        returnString += String.format("%n\tLosses Against (%s):", data.getLostTo().size());
        for( Map.Entry<Option, Integer> e: data.getLostTo().entrySet()) {
            returnString += " " + e.getKey() + ":" + e.getValue();
        }
        return returnString;

    }
}
