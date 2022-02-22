package ca.kendon.categoryvote;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CategoryLoader {

    private static final String CATEGORY_FIELD_SEPARATOR = ",";

    public static Category load(String categoryString) {

        List<String> categoryData = new ArrayList(Arrays.asList(categoryString.split(CATEGORY_FIELD_SEPARATOR)));

        String name = categoryData.remove(0);
        int points = Integer.parseInt(categoryData.remove(0).trim());
        ArrayList<String> ccd = new ArrayList<>();
        for (String s : categoryData) {
            ccd.add(s.trim());
        }

        return new Category(name, points, ccd);

    }

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
