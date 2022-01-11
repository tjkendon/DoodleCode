package ca.kendon.list_difference;

import org.jetbrains.annotations.NotNull;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListDifferenceEngine {

    ListDifference difference;

    public ListDifferenceEngine(File fileA, File fileB) {

        Collection<String> a = loadFromFile(fileA);
        Collection<String> b = loadFromFile(fileB);

        difference = new ListDifference(a, b);

    }

    @NotNull
    private Collection<String> loadFromFile(File file) {
        ArrayList<String> data = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                data.add(scanner.nextLine());
            }

        } catch (FileNotFoundException e) {
            Logger.getLogger("ListDifference").log(
                    Level.WARNING, String.format("File Not Found: %s", file.getName()));
        }

        return data;
    }

}
