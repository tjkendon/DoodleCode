package ca.kendon.categoryvote;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * Loader to manage reading question data from files.
 *
 */

public class QuestionLoader {

    private static final String QUESTION_FIELD_SEPERATER = ",";

    /**
     *
     * Parsing a question from a string, checking that it matches the given list of categories
     *
     * @param questionString the string with the infromation for the question
     * @param categories the list of categories to which points can be assigned in the question
     * @return the question based on the provided string
     */
    public static Question load(String questionString, List<Category> categories) {

        List<String> questionData = new ArrayList<>(Arrays.asList(questionString.split(QUESTION_FIELD_SEPERATER)));
        // first two elements are the name and stem, remove those so we can use the rest of the data for options
        String name = questionData.remove(0).trim();
        String stem = questionData.remove(0).trim();
        List<Option> options = new ArrayList<>();
        // each remaining element should be an option.
        while (!questionData.isEmpty()) {
            options.add(OptionLoader.load(questionData.remove(0), categories));
        }
        return new Question(name, stem, options);

    }

    /**
     *
     * Reads questions out of a file. Each question must refer to matching categories.
     * Unmatching lines are skipped.
     *
     * @param file the file to read from
     * @param categories the categories to match against
     * @return a list of questions loaded from the file.
     * @throws FileNotFoundException if the file cannot be found
     */
    public static List<Question> readFile(File file, List<Category> categories) throws FileNotFoundException {
        List<Question> questions = new ArrayList<>();

        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            try {
                questions.add(load(scanner.nextLine(), categories));
            } catch (Exception e) {
                System.err.println("Not able to read line");
            }
        }

        scanner.close();

        return questions;
    }

}
