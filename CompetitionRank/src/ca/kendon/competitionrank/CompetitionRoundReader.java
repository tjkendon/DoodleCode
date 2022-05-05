package ca.kendon.competitionrank;

public class CompetitionRoundReader {


    public CompetitionRound read(String roundData) {


        String name = "Read";
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

}
