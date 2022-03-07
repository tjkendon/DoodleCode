package ca.kendon.food_o_rac_o_cycle;

import java.io.File;
import java.io.FileNotFoundException;

public class FoRoC {

    public static void main(String[] args) {

        System.out.println("Food'o'rac'o'cycle");
        try {
            ForocEngine engine = new ForocEngine(new File(args[0]));
            System.out.println("Make " + engine.choose());
        } catch (FileNotFoundException e) {
            System.err.println("Unable to open file: " + args[0]);
        }

    }
}
