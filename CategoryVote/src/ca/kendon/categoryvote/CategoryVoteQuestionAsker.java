package ca.kendon.categoryvote;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CategoryVoteQuestionAsker {

    public static void main(String[] args) {


        File categoryFile = new File(args[0]);
        File questionFile = new File(args[1]);
        File responseFile = new File(args[2]);

        try {
            CategoryVoteQuestionAsker asker = new CategoryVoteQuestionAsker(categoryFile, questionFile, responseFile);
            asker.run();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    private List<Category> categories;
    private List<Question> questions;

    private File responseFile;

    public CategoryVoteQuestionAsker(File categoryFile, File questionFile, File responseFile) throws FileNotFoundException {

            categories = CategoryLoader.readFile(categoryFile);
            questions = QuestionLoader.readFile(questionFile, categories);


        this.responseFile = responseFile;


    }

    public void run() throws FileNotFoundException {

        List<Response> responses = askQuestions(questions);

        ResponseLoader.writeFile(responseFile, responses);
    }

    private List<Response> askQuestions(List<Question> questions) {

        Scanner reader = new Scanner(System.in);

        ArrayList<Response> responses = new ArrayList<>();

        System.out.println("Please answer the following questions:");
        int questionNumber = 1;
        for (Question q : questions) {
            System.out.println("Question " + questionNumber++ + ": " + q.getName());
            System.out.println(q.getStem());
            int optionNumber = 1;
            for (Option o : q.getOptions()) {
                System.out.println(optionNumber++ + ") " + o.getText());
            }
            System.out.print("Choice: ");
            int choice = reader.nextInt();
            Response r = new Response(q, q.getOptions().get(choice - 1));
            responses.add(r);
            System.out.println("Picked " + r.getChoice().getText());
            System.out.println();
        }

        return responses;

    }


}
