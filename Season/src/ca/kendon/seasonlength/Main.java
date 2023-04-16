package ca.kendon.seasonlength;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        System.out.println("Test Season");

        for (int i = 2; i <= 5; i++) {
            CompetetorDataGenerator generator = new SimpleCompetitorListGenerator(i);
            List<Competitor> competitors = generator.getCompetitors();
            System.out.println(competitors);
        }





        System.out.println("Done");


    }
}
