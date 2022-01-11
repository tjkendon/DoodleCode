package ca.kendon.list_difference;

import java.io.File;

public class Main {

    public static void main(String[] args) {


        File fileA = new File("data/testA");
        File fileB = new File("data/testB");
        ListDifferenceEngine engine = new ListDifferenceEngine(fileA, fileB);
        ListDifference difference = engine.getListDifference();
        System.out.println(String.format("A: %s", difference.getA()));
        System.out.println(String.format("B: %s", difference.getB()));
        System.out.println(String.format("A U B: %s", difference.union()));
        System.out.println(String.format("/A: %s", difference.onlyInA()));
        System.out.println(String.format("%%/A: %s", difference.percentInA()));
        System.out.println(String.format("/B: %s", difference.onlyInB()));
        System.out.println(String.format("%%/B: %s",difference.percentInB()));
        System.out.println(String.format("A^ B: %s", difference.intersection()));
        System.out.println(String.format("%%A ^ B: %s", difference.similarity()));



    }
}
