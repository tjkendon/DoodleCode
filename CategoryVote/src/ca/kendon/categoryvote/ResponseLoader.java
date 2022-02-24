package ca.kendon.categoryvote;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ResponseLoader {

    private static final String RESPONSE_FIELD_SEPARATOR = ",";

    public static Response load(String responseString, List<Question> questions) {

        List<String> responseData = new ArrayList<>(Arrays.asList(responseString.split(RESPONSE_FIELD_SEPARATOR)));

        for (Question q : questions) {
            if (q.getName().equals(responseData.get(0).trim())) {
                for (Option o : q.getOptions()) {
                    if (o.getText().equals(responseData.get(1).trim())) {
                        return new Response(q, o);
                    }
                }
            }
        }
        throw new IllegalArgumentException("Not able to find matching question or option: " + responseString);

    }

    public static List<Response> readFile(File file, List<Question> questions) throws FileNotFoundException {
        List<Response> responses = new ArrayList<>();

        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            responses.add(load(scanner.nextLine(), questions));
        }

        scanner.close();

        return responses;
    }

}
