package ca.kendon.categoryvote;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


/**
 *
 * Manages response information in text and files.
 *
 */
public class ResponseLoader {

    /**
     * Separator for the question and response in the response line
     */
    private static final String RESPONSE_FIELD_SEPARATOR = ",";

    /**
     *
     * Parses a response from a string, checking it against the provided list of quesitons. The question,
     * and selected, must match the provided list.
     *
     * Format for the string must mach: Question Name, Option
     *
     * @param responseString string to be parsed
     * @param questions the list of questions the response will be checked against
     * @return a response if the string is well formed
     */
    public static Response parseResponse(String responseString, List<Question> questions) {

        List<String> responseData = new ArrayList<>(Arrays.asList(responseString.split(RESPONSE_FIELD_SEPARATOR)));

        // process the questions to find one whose name matches the name portion of the string
        for (Question q : questions) {
            if (q.getName().equals(responseData.get(0).trim())) {
                // process the question's options to find one whose text matches the option portion of the string
                for (Option o : q.getOptions()) {
                    if (o.getText().equals(responseData.get(1).trim())) {
                        return new Response(q, o);
                    }
                }
            }
        }
        // throw exception if the string doesn't match a question or the question's options
        throw new IllegalArgumentException("Not able to find matching question or option: " + responseString);

    }

    /**
     *
     * Reads responses out of a file. Each response must match a question and it's option from the list
     * of options. Unmatching lines will be skipped.
     *
     * @param file response file to read
     * @param questions list of questions to test against
     *
     * @return a list of responses lead out of the file.
     *
     * @throws FileNotFoundException if the file can't be found
     */
    public static List<Response> readFile(File file, List<Question> questions) throws FileNotFoundException {
        List<Response> responses = new ArrayList<>();

        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            try {
                responses.add(parseResponse(scanner.nextLine(), questions));
            } catch (IllegalArgumentException iae) {
                System.err.println("Unreadable line: " + iae.getLocalizedMessage());
            }
        }

        scanner.close();

        return responses;
    }

    /**
     *
     * Writes responses out to a file, matching the format needed to read them back in.
     *
     * @param responseFile the file to write the responses to
     * @param responses the responeses to write to the file
     * @throws FileNotFoundException if the file cannot be found
     */
    public static void writeFile(File responseFile, List<Response> responses) throws FileNotFoundException {

        PrintStream print = new PrintStream(responseFile);
        for (Response r : responses) {
            print.println(r.getQuestion().getName() + ", " + r.getChoice().getText());
        }
        print.close();


    }

    /**
     *
     * Reads all responses from all files ending in ".response" in the given directory.
     *
     * @param responseDirectory the directory to search for ".response" files
     * @param questions the list of questions to verify the responses against
     * @return a list of all responses in all files
     * @throws FileNotFoundException if the directory cannot be found
     */
    public static List<Response> readDirectory(File responseDirectory, List<Question> questions) throws FileNotFoundException {
        List<Response> allResponses = new ArrayList<>();
        // process every file that ends in .response in the given directory
        for (File f : responseDirectory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".response");
            }
        })) {
         allResponses.addAll(readFile(f, questions));
        }
        return allResponses;
    }
}
