package ca.kendon.categoryvote;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class CategoryVoteResultCalgulator {


    /**
     * List of loaded categories
     */
    private List<Category> categories;
    /**
     * List of loaded questions
     */
    private List<Question> questions;
    /**
     * List of L
     */
    private List<Response> responses;

    public static void main(String[] args) {

        try {
            CategoryVoteResultCalgulator calculator = new CategoryVoteResultCalgulator(
                    new File(args[0]),
                    new File(args[1]),
                    new File(args[2]));
            List<String> results = calculator.run(Integer.parseInt(args[3]));

            System.out.println(results);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    public CategoryVoteResultCalgulator(File categoryFile, File questionFile, File responseFile)
            throws FileNotFoundException {

        categories = CategoryLoader.readFile(categoryFile);
        questions = QuestionLoader.readFile(questionFile, categories);
        if (responseFile.isDirectory()) {
            responses = ResponseLoader.readDirectory(responseFile, questions);
        } else {
            responses = ResponseLoader.readFile(responseFile, questions);
        }

    }

    public List<String> run(int winners) {
        VotingEngine engine = new VotingEngine(categories);
        return engine.evaluate(responses, 4);

    }

}
