package ca.kendon.categoryvote;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionLoaderTest {

    @Test
    void load() {

        List<String> cat1Stuff = new ArrayList<>();
        cat1Stuff.add("1_1");
        cat1Stuff.add("1_2");
        cat1Stuff.add("1_3");
        cat1Stuff.add("1_4");
        Category cat1 = new Category("C1", 10, cat1Stuff);

        List<String> cat2Stuff = new ArrayList<>();
        cat2Stuff.add("2_1");
        cat2Stuff.add("2_2");
        cat2Stuff.add("2_3");
        cat2Stuff.add("2_4");
        Category cat2 = new Category("C2", 10, cat2Stuff);

        List<String> cat3Stuff = new ArrayList<>();
        cat3Stuff.add("3_1");
        cat3Stuff.add("3_2");
        cat3Stuff.add("3_3");
        cat3Stuff.add("3_4");
        Category cat3 = new Category("C3", 10, cat3Stuff);

        List<Category> categories = new ArrayList<>();
        categories.add(cat1);
        categories.add(cat2);
        categories.add(cat3);


        HashMap<Category, Integer> aMap = new HashMap<>();
        aMap.put(cat1, 5);
        aMap.put(cat2, 3);
        aMap.put(cat3, 1);

        HashMap<Category, Integer> bMap = new HashMap<>();
        bMap.put(cat1, 2);
        bMap.put(cat2, 10);

        HashMap<Category, Integer> cMap = new HashMap<>();
        cMap.put(cat1, 3);
        cMap.put(cat2, 4);
        cMap.put(cat3, 5);


        Option a = new Option("A1", aMap);
        Option b = new Option("A2", bMap);
        Option c = new Option("A3", cMap);

        ArrayList<Option> options = new ArrayList<>();
        options.add(a);
        options.add(b);
        options.add(c);

        Question expected = new Question("Question 1", "What do?", options);

        String questionString = "Question 1, What do?, A1-C1:5-C2:3-C3:1, A2-C1:2-C2:10, A3-C1:3-C2:4-C3:5";
        Question actual = QuestionLoader.load(questionString, categories);

        assertEquals(expected, actual);

    }
}
