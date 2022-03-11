package ca.kendon.categoryvote;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *
 * Manages Category information in text and files
 *
 */
public class CategoryLoader {

    private static final String CATEGORY_FIELD_SEPARATOR = ",";

    /**
     *
     * Parses a Category out of the given string.
     *
     * Format for the category string is: name, victory point reduction, victory items...
     *
     * @param categoryString the string to parse the category information from.
     * @return the category
     */
    public static Category load(String categoryString) {

        List<String> categoryData = new ArrayList<>(Arrays.asList(categoryString.split(CATEGORY_FIELD_SEPARATOR)));

        String name = categoryData.remove(0);
        int points = Integer.parseInt(categoryData.remove(0).trim());
        ArrayList<String> ccd = new ArrayList<>();
        for (String s : categoryData) {
            ccd.add(s.trim());
        }

        return new Category(name, points, ccd);

    }

    /**
     *
     * Reads category information from file
     *
     * @param file the file of category information
     * @return the list of categories.
     * @throws FileNotFoundException if the file cannot be found
     */
    public static List<Category> readFile(File file) throws FileNotFoundException {
        List<Category> categories = new ArrayList<>();

        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            categories.add(load(scanner.nextLine()));
        }

        scanner.close();

        return categories;
    }
}
