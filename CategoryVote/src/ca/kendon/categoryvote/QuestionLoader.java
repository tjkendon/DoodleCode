package ca.kendon.categoryvote;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class QuestionLoader {

    private static final String QUESTION_FIELD_SEPERATER = ",";

    public static Question load(String questionString, List<Category> categories) {

        List<String> questionData = new ArrayList<>(Arrays.asList(questionString.split(QUESTION_FIELD_SEPERATER)));
        String name = questionData.remove(0).trim();
        String stem = questionData.remove(0).trim();
        List<Option> options = new ArrayList<>();
        while (!questionData.isEmpty()) {
            options.add(OptionLoader.load(questionData.remove(0), categories));
        }
        return new Question(name, stem, options);

    }

    public static List<Question> readFile(File file, List<Category> categories) throws FileNotFoundException {
        List<Question> questions = new ArrayList<>();

        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            questions.add(load(scanner.nextLine(), categories));
        }

        scanner.close();

        return questions;
    }

}
