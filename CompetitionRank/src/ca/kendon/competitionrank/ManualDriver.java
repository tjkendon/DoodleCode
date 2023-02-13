package ca.kendon.competitionrank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.List;

public class ManualDriver {

    public static void main (String[] args) {

        mock();
    }

    public static void marioKart() {
        List<CompetitionRound> competitionRounds = null;
        try {
            competitionRounds = CompetitionRoundReader.readFile(new File("data/mk2.csv"));
            System.out.println(competitionRounds);

            Option defaultOption = new Option("Random");

            Ranking ranking = new Ranking(defaultOption);
            ranking.rankOptions(competitionRounds);
            System.out.println("Name: " + ranking.optionsBySort(new OptionDataOptionNameComperator()));
            System.out.println("PowerRank: " + ranking.optionsBySort(new OptionDataPowerRankComparator(defaultOption)));
            System.out.println("Count: " + ranking.optionsBySort(new Comparator<OptionData>() {
                @Override
                public int compare(OptionData o1, OptionData o2) {
                    return Integer.compare(o2.getCount(), o1.getCount());
                }
            }));

            System.out.println(ranking.getData());

            for (Option o: ranking.getData().keySet()) {
                System.out.println(OptionDataPrinter.fullDataPretty(ranking.getData().get(o), defaultOption));
            }
            for (Option o: ranking.getData().keySet()) {
                System.out.println(OptionDataPrinter.fullDataCSV(ranking.getData().get(o), defaultOption));
            }
            ranking.getQualityOfCompetition();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void mock() {
        List<CompetitionRound> competitionRounds = null;
        try {
            competitionRounds = CompetitionRoundReader.readFile(new File("data/mock_6.csv"));

            Option defaultOption = new Option("Course A");

            Ranking ranking = new Ranking(defaultOption);
            ranking.rankOptions(competitionRounds);

            for (Option o: ranking.getData().keySet()) {
                System.out.println(OptionDataPrinter.fullDataPretty(ranking.getData().get(o), defaultOption));
            }
            for (Option o: ranking.getData().keySet()) {
                System.out.println(OptionDataPrinter.fullDataCSV(ranking.getData().get(o), defaultOption));
            }
            ranking.getQualityOfCompetition();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}