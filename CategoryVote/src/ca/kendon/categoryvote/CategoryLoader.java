package ca.kendon.categoryvote;

import java.util.Arrays;
import java.util.List;

public class CategoryLoader {

    private static final String CATEGORY_FIELD_SEPARATOR = ",";

    public static Category load(String categoryString) {

        List<String> categoryData = Arrays.asList(categoryString.split(CATEGORY_FIELD_SEPARATOR));
        String name = categoryData.remove(0);
        int points = Integer.parseInt(categoryData.remove(0));

        return new Category(name, points, categoryData);

    }
}
