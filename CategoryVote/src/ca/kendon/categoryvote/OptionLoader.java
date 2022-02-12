package ca.kendon.categoryvote;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OptionLoader {

    private static final String OPTION_FIELD_SEPARATOR = "-";
    private static final String MAP_FIELD_SEPARATOR = ":";

    public static Option load(String optionString, List<Category> categories) {


        List<String> optionData = Arrays.asList(optionString.split(OPTION_FIELD_SEPARATOR));
        String text = optionData.remove(0);

        Map<Category, Integer> assignmentValues = new HashMap<>();
        for (String data : optionData) {
            List<String> categoryData = Arrays.asList(data.split(MAP_FIELD_SEPARATOR));
            for (Category c : categories) {
                if (c.getName().equals(categoryData.get(0))) {
                    assignmentValues.put(c, Integer.parseInt(categoryData.get(1)));
                }
            }
        }


        return new Option(text, assignmentValues);

    }

}
