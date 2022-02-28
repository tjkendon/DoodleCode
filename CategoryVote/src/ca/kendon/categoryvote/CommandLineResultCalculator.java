package ca.kendon.categoryvote;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class CommandLineResultCalculator {


    private List<Category> categories;
    private List<Question> questions;
    private List<Response> responses;

    public static void main(String[] args) {

        try {
            CommandLineResultCalculator calculator = new CommandLineResultCalculator(
                    new File(args[0]),
                    new File(args[1]),
                    new File(args[2]));
            List<String> results = calculator.run(Integer.parseInt(args[3]));

            System.out.println(results);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    public CommandLineResultCalculator(File categoryFile, File questionFile, File responseFile)
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
