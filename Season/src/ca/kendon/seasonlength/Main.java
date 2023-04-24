package ca.kendon.seasonlength;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        System.out.println("Test Experiment");

        CompetetorDataGenerator competetorGenerator = new SimpleCompetitorListGenerator(4);
        List<Competitor> competitors = competetorGenerator.getCompetitors();
        Experiment experiment = new SimpleExperiment(competitors, new Simple2PointModel(), new NaiveCompetition());
        experiment.run();


        System.out.println("Done");


    }
}
