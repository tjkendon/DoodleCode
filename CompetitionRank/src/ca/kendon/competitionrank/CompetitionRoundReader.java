package ca.kendon.competitionrank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompetitionRoundReader {


    public static CompetitionRound read(String roundData) {

        String name = "Round Data";
        String[] data = roundData.split(",");
        int firstEntry = 0;

        if (data.length % 2 != 0) {
            name = data[0];
            firstEntry = 1;
        }

        CompetitionRound round = new CompetitionRound(name);

        for (int i = firstEntry; i < data.length; i += 2) {
            round.putOption(new Option(data[i].trim()), Integer.parseInt(data[i+1].trim()));
        }

        return round;
    }

    public static List<CompetitionRound> readFile(File file) throws FileNotFoundException {
        List<CompetitionRound> rounds = new ArrayList<>();

        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            rounds.add(read(scanner.nextLine()));
        }

        scanner.close();

        return rounds;
    }

}
