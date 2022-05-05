package ca.kendon.competitionrank;

public class CompetitionRoundReader {


    public CompetitionRound read(String roundData) {

        CompetitionRound round = new CompetitionRound();


        String[] data = roundData.split(",");
        for (int i = 0; i < data.length; i += 2) {
            round.putOption(new Option(data[i].trim()), Integer.parseInt(data[i+1].trim()));
        }

        return round;
    }

}
