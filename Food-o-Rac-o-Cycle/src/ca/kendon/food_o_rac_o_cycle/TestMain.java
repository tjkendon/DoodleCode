package ca.kendon.food_o_rac_o_cycle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMain {

    public static void main(String[] args) {
        testForoc(args);
        testForocEngine(args);
    }

    public static void testForocEngine(String[] args) {

        try {
            FoodORacOCycleEngine foroc = new FoodORacOCycleEngine(new File("data/testmeals.data"));
            System.out.println(foroc.choose());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void testForoc(String[] args) {

        FoodORacOCycleChooser frc = new FoodORacOCycleChooser();

        List<Meal> meals = new ArrayList<>();
        meals.add(new Meal("Test1", 10));
        meals.add(new Meal("Test2", 10));
        meals.add(new Meal("Test3", 10));
        meals.add(new Meal("Test4", 10));
        meals.add(new Meal("Test5", 10));
        meals.add(new Meal("Test6", 10));

        frc.addMeals(meals);

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
