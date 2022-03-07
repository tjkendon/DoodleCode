package ca.kendon.categoryvote;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResponseLoaderTest {


    @Test
    void load() {

        List<String> cat1Stuff = new ArrayList<>();
        cat1Stuff.add("1_1");
        cat1Stuff.add("1_2");
        cat1Stuff.add("1_3");
        cat1Stuff.add("1_4");
        Category cat1 = new Category("Cat1", 10, cat1Stuff);

        List<String> cat2Stuff = new ArrayList<>();
        cat2Stuff.add("2_1");
        cat2Stuff.add("2_2");
        cat2Stuff.add("2_3");
        cat2Stuff.add("2_4");
        Category cat2 = new Category("Cat2", 10, cat2Stuff);

        List<String> cat3Stuff = new ArrayList<>();
        cat3Stuff.add("3_1");
        cat3Stuff.add("3_2");
        cat3Stuff.add("3_3");
        cat3Stuff.add("3_4");
        Category cat3 = new Category("Cat3", 10, cat3Stuff);

        HashMap<Category, Integer> aMap = new HashMap<>();
        aMap.put(cat1, 5);
        aMap.put(cat2, 8);
        aMap.put(cat3, 2);

        HashMap<Category, Integer> bMap = new HashMap<>();
        bMap.put(cat1, 3);
        bMap.put(cat2, 2);
        bMap.put(cat3, 9);

        HashMap<Category, Integer> cMap = new HashMap<>();
        cMap.put(cat1, 7);
        cMap.put(cat2, 3);
        cMap.put(cat3, 3);

        HashMap<Category, Integer> dMap = new HashMap<>();
        dMap.put(cat1, 0);
        dMap.put(cat2, 10);
        dMap.put(cat3, 0);

        Option a = new Option("A?", aMap);
        Option b = new Option("B?", bMap);
        Option c = new Option("C?", cMap);
        Option d = new Option("D?", dMap);

        List<Option> o = new ArrayList<>();
        o.add(a);
        o.add(b);
        o.add(c);
        o.add(d);

        Question q1 = new Question("ABCD", "A, B, C or D", o);

        List<Question> questions = new ArrayList<>();
        questions.add(q1);

        Response actual = ResponseLoader.parseResponse("ABCD, A?", questions);

        Response expected = new Response(q1, a);

        assertEquals(actual, expected);




    }

}
