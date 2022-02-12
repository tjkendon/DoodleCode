package ca.kendon.categoryvote;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionLoader {

    private static final String QUESTION_FIELD_SEPERATER = ",";

    public static Question load(String questionString, List<Category> categories) {

        List<String> questionData = Arrays.asList(questionString.split(QUESTION_FIELD_SEPERATER));
        String name = questionData.remove(0);
        String stem = questionData.remove(0);
        List<Option> options = new ArrayList<>();
        while (!questionData.isEmpty()) {
            options.add(OptionLoader.load(questionData.remove(0), categories));
        }
        return new Question(name, stem, options);

    }

}
