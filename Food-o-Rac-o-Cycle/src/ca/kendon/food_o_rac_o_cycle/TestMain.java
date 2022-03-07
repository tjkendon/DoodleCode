package ca.kendon.food_o_rac_o_cycle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class TestMain {

    public static void main(String[] args) {
        testForoc(args);
        testForocEngine(args);
    }

    public static void testForocEngine(String[] args) {

        try {
            ForocEngine foroc = new ForocEngine(new File("data/testmeals.data"));
            System.out.println(foroc.choose());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void testForoc(String[] args) {

        FoodORacOCycle frc = new FoodORacOCycle();
        frc.addMeal("Test1", 10);
        frc.addMeal("Test2", 20);
        frc.addMeal("Test3", 30);
        frc.addMeal("Test4", 40);
        frc.addMeal("Test5", 50);
        frc.addMeal("Test6", 60);

        // map for counting outcomes
        Map<String, Integer> results = new HashMap<>();
        results.put("Test1", 0);
        results.put("Test2", 0);
        results.put("Test3", 0);
        results.put("Test4", 0);
        results.put("Test5", 0);
        results.put("Test6", 0);

        // draw 1000 meals and count how often each type is pulled
        for (int i = 0; i < 1000; i++) {
            String name = frc.chooseMeal().getName();
            results.put(name, results.get(name)+1);
        }

        System.out.println(results);

    }
}
