package ca.kendon.categoryvote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class LineDriver {

    public static void main (String[] args) {

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

        Response r1_1 = new Response(q1, a);
        Response r1_2 = new Response(q1, b);
        Response r1_3 = new Response(q1, c);
        Response r1_4 = new Response(q1, d);
        Response r1_5 = new Response(q1, b);
        Response r1_6 = new Response(q1, b);

        ArrayList<Response> responses = new ArrayList<>();
//        responses.add(r1_1);
//        responses.add(r1_2);
//        responses.add(r1_3);
//        responses.add(r1_4);
//        responses.add(r1_5);
//        responses.add(r1_6);

        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            responses.add(new Response(q1, o.get(r.nextInt(o.size()))));
        }

        ArrayList<Category> cats = new ArrayList<>();
        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);

        VotingEngine engine = new VotingEngine(cats);
        List<String> results = engine.evaluate(responses, 4);
        System.out.println(results);

    }

}
