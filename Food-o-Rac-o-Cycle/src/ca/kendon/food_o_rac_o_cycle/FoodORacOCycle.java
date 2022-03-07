package ca.kendon.food_o_rac_o_cycle;

import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * Main class for Food'o'rac'o'cycle. Takes the file name from the first argument
 * and returns one randomly selected meal (affected by weights).
 *
 */
public class FoodORacOCycle {

    /**
     *
     * main() for the Food'O'Rac'O'Cycle.
     *
     * @param args system args
     */
    public static void main(String[] args) {

        System.out.println("Food'o'rac'o'cycle");
        try {
            FoodORacOCycleEngine engine = new FoodORacOCycleEngine(new File(args[0]));
            System.out.println("Make " + engine.choose());
        } catch (FileNotFoundException e) {
            System.err.println("Unable to open file: " + args[0]);
        }

    }
}
