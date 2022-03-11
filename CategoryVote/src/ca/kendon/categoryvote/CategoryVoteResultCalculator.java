package ca.kendon.categoryvote;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

/**
 *
 * Main class to tabulate responses and calculate category vote results
 *
 */
public class CategoryVoteResultCalculator {


    /**
     * List of loaded categories
     */
    private final List<Category> categories;

    /**
     * List of loaded responses
     */
    private final List<Response> responses;

    /**
     *
     * Rickity - options must be presented in sequence, category file, question file, results file, # of winners
     *
     * @param args system args
     */
    public static void main(String[] args) {

        try {
            CategoryVoteResultCalculator calculator = new CategoryVoteResultCalculator(
                    new File(args[0]),
                    new File(args[1]),
                    new File(args[2]));
            List<String> results = calculator.run(Integer.parseInt(args[3]));

            System.out.println(results);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    /**
     *
     * Loads all categories, questions and responses. If response file is a directory, loads all files
     *
     * @param categoryFile the file with category information
     * @param questionFile the file with question information
     * @param responseFile the file with response information (or directory)
     * @throws FileNotFoundException if any of the files cannot be found
     */
    public CategoryVoteResultCalculator(File categoryFile, File questionFile, File responseFile)
            throws FileNotFoundException {

        categories = CategoryLoader.readFile(categoryFile);
        List<Question> questions = QuestionLoader.readFile(questionFile, categories);
        if (responseFile.isDirectory()) {
            responses = ResponseLoader.readDirectory(responseFile, questions);
        } else {
            responses = ResponseLoader.readFile(responseFile, questions);
        }

    }

    /**
     *
     * Runs the voting engine with the categories and responses and returns the given number of victory results
     * from the cateogories.
     *
     * @param winners the number of victory items to return
     * @return the list of victory items
     */
    public List<String> run(int winners) {
        VotingEngine engine = new VotingEngine(categories);
        return engine.evaluate(responses, winners);

    }

}
