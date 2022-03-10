package ca.kendon.categoryvote;

import java.util.*;

/**
 *
 * Manages option information in text.
 *
 */
public class OptionLoader {

    /**
     * Format for option is text-category:weight-category:weight
     */
    private static final String OPTION_FIELD_SEPARATOR = "-";
    private static final String MAP_FIELD_SEPARATOR = ":";

    /**
     *
     * Parses option information from a string and matches it against the list of categories
     *
     * Format: text-category:weight-category:weight
     *
     * @param optionString the string with the option information
     * @param categories the list of categories to match against
     * @return the option based on the provided string
     */
    public static Option load(String optionString, List<Category> categories) {


        List<String> optionData = new ArrayList<>(Arrays.asList(optionString.split(OPTION_FIELD_SEPARATOR)));
        // first value is the option text
        String text = optionData.remove(0).trim();

        // then we need to go through all following fields and find the matching category to put in the map
        Map<Category, Integer> assignmentValues = new HashMap<>();
        for (String data : optionData) {
            List<String> categoryData = Arrays.asList(data.split(MAP_FIELD_SEPARATOR));
            for (Category c : categories) {
                if (c.getName().equals(categoryData.get(0))) {
                    assignmentValues.put(c, Integer.parseInt(categoryData.get(1).trim()));
                }
            }
        }

        return new Option(text, assignmentValues);

    }

}
