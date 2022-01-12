package ca.kendon.list_difference;

import java.io.File;

public class Main {

    public static void main(String[] args) {


        File fileA = new File("data/testA");
        File fileB = new File("data/testB");
        ListDifferenceEngine engine = new ListDifferenceEngine(fileA, fileB);
        ListDifference difference = engine.getListDifference();
        System.out.printf("A: %s%n", difference.getA());
        System.out.printf("B: %s%n", difference.getB());
        System.out.printf("A U B: %s%n", difference.union());
        System.out.printf("/A: %s%n", difference.onlyInA());
        System.out.printf("%%/A: %s%n", difference.percentInA());
        System.out.printf("/B: %s%n", difference.onlyInB());
        System.out.printf("%%/B: %s%n",difference.percentInB());
        System.out.printf("A^ B: %s%n", difference.intersection());
        System.out.printf("Jaccard(A, B): %s%n", difference.jaccardSimilarity());
        System.out.printf("SD(A, B): %s%n", difference.sdSimilarity());
        System.out.printf("O(A, B): %s%n", difference.overlapSimilarity());



    }
}
