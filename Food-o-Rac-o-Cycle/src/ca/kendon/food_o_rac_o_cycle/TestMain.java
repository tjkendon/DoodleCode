package ca.kendon.food_o_rac_o_cycle;

import java.util.HashMap;
import java.util.Map;

public class TestMain {

    public static void main(String[] args) {

        FoodORacOCycle frc = new FoodORacOCycle();
        frc.addMeal("Test1", 10);
        frc.addMeal("Test2", 20);
        frc.addMeal("Test3", 30);
        frc.addMeal("Test4", 40);
        frc.addMeal("Test5", 50);
        frc.addMeal("Test6", 60);

        Map<String, Integer> results = new HashMap<>();
        results.put("Test1", 0);
        results.put("Test2", 0);
        results.put("Test3", 0);
        results.put("Test4", 0);
        results.put("Test5", 0);
        results.put("Test6", 0);

        for (int i = 0; i < 1000; i++) {
            String name = frc.chooseMeal().getName();
            results.put(name, results.get(name)+1);
        }

        System.out.println(results);

    }
}
