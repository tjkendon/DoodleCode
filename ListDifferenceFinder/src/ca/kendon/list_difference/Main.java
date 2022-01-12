package ca.kendon.list_difference;

import java.io.File;

public class Main {

    public static void main(String[] args) {

    }

    public static void printAll() {
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

    public static String generateString() {
        StringBuilder builder = new StringBuilder();
        return builder.toString();
    }

    private static class outputControl {
        private boolean showA = false;
        private boolean showB = false;
        private boolean showUnion = false;
        private boolean showIntersection = false;
        private boolean showUniqueA = false;
        private boolean showUniqueB = false;
        private boolean showAPercent = false;
        private boolean showBPercent = false;
        private boolean showJaccard = false;
        private boolean showSD = false;
        private boolean showOverlap = false;

        public boolean isShowA() {
            return showA;
        }

        public void setShowA(boolean showA) {
            this.showA = showA;
        }

        public boolean isShowB() {
            return showB;
        }

        public void setShowB(boolean showB) {
            this.showB = showB;
        }

        public boolean isShowUnion() {
            return showUnion;
        }

        public void setShowUnion(boolean showUnion) {
            this.showUnion = showUnion;
        }

        public boolean isShowIntersection() {
            return showIntersection;
        }

        public void setShowIntersection(boolean showIntersection) {
            this.showIntersection = showIntersection;
        }

        public boolean isShowUniqueA() {
            return showUniqueA;
        }

        public void setShowUniqueA(boolean showUniqueA) {
            this.showUniqueA = showUniqueA;
        }

        public boolean isShowUniqueB() {
            return showUniqueB;
        }

        public void setShowUniqueB(boolean showUniqueB) {
            this.showUniqueB = showUniqueB;
        }

        public boolean isShowAPercent() {
            return showAPercent;
        }

        public void setShowAPercent(boolean showAPercent) {
            this.showAPercent = showAPercent;
        }

        public boolean isShowBPercent() {
            return showBPercent;
        }

        public void setShowBPercent(boolean showBPercent) {
            this.showBPercent = showBPercent;
        }

        public boolean isShowJaccard() {
            return showJaccard;
        }

        public void setShowJaccard(boolean showJaccard) {
            this.showJaccard = showJaccard;
        }

        public boolean isShowSD() {
            return showSD;
        }

        public void setShowSD(boolean showSD) {
            this.showSD = showSD;
        }

        public boolean isShowOverlap() {
            return showOverlap;
        }

        public void setShowOverlap(boolean showOverlap) {
            this.showOverlap = showOverlap;
        }
    }
}
