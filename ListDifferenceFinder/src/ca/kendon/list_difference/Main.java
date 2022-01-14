package ca.kendon.list_difference;

import org.apache.commons.cli.*;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        OutputControl control = generateControl(args);
        ListDifferenceEngine engine = new ListDifferenceEngine(control.getFileA(), control.getFileB());
        System.out.println(generateOutputString(control, engine.getListDifference()));

    }


    public static OutputControl generateControl(String[] args) {
        Options options = new Options();
        options.addOption(
                "a",
                "showA",
                false,
                "show the elements in a");
        options.addOption(
                "b",
                "showB",
                false,
                "show the elements in b");
        options.addOption(
                "u",
                "showUnion",
                false,
                "show the elements in the union");
        options.addOption(
                "i",
                "showIntersection",
                false,
                "show the elements in the intersection");
        options.addOption(
                "A",
                "uniqueA",
                false,
                "show the unique elements in A");
        options.addOption(
                "B",
                "uniqueB",
                false,
                "show the unique elements in B");
        options.addOption(
                "p",
                "percentA",
                false,
                "show the percentage of unique elements in A");
        options.addOption(
                "q",
                "percentB",
                false,
                "show the percentage of unique elements in B");
        options.addOption(
                "j",
                "showJaccard",
                false,
                "show the Jaccard similarity between A and B");
        options.addOption(
                "s",
                "showSD",
                false,
                "show the Soerensen-Dice similarity between A and B");
        options.addOption(
                "o",
                "showO",
                false,
                "show the Szymkiewicz–Simpson similarity between A and B");

        OutputControl control = new OutputControl();

        CommandLineParser parser = new DefaultParser();

        try {
            CommandLine cl = parser.parse(options, args);

            if (cl.getOptions().length == 0) {
                control = OutputControl.defaultControl();
            }

            if (cl.hasOption("showA")) {
                control.setShowA(true);
            }
            if (cl.hasOption("showB")) {
                control.setShowB(true);
            }
            if (cl.hasOption("showUnion")) {
                control.setShowUnion(true);
            }
            if (cl.hasOption("showIntersection")) {
                control.setShowIntersection(true);
            }
            if (cl.hasOption("uniqueA")) {
                control.setShowUniqueA(true);
            }
            if (cl.hasOption("uniqueB")) {
                control.setShowUniqueB(true);
            }
            if (cl.hasOption("percentA")) {
                control.setShowAPercent(true);
            }
            if (cl.hasOption("percentB")) {
                control.setShowBPercent(true);
            }
            if (cl.hasOption("showJaccard")) {
                control.setShowJaccard(true);
            }
            if (cl.hasOption("showSD")) {
                control.setShowSD(true);
            }
            if (cl.hasOption("showO")) {
                control.setShowOverlap(true);
            }
            if (args.length >= 2) {
                control.setFileA(new File(args[args.length - 2]));
                control.setFileB(new File(args[args.length - 1]));
            } else {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("ListDifference <options> fileA fileB", options);
            }
        } catch (ParseException e) {
            Logger.getLogger("ListDifference").log(
                    Level.WARNING, String.format("Error parsing command line %s", e.getLocalizedMessage()));

        }

        return control;

    }

    public static String generateOutputString(OutputControl control, ListDifference difference) {
        StringBuilder builder = new StringBuilder();

        if (control.isShowA()) {
            builder.append(String.format("A: %s%n", difference.getA()));
        }
        if (control.isShowUniqueA()) {
            builder.append(String.format("/A: %s%n", difference.onlyInA()));
        }
        if (control.isShowAPercent()) {
            builder.append(String.format("%%/A: %s%n", difference.percentInA()));
        }
        if (control.isShowB()) {
            builder.append(String.format("B: %s%n", difference.getB()));
        }
        if (control.isShowUniqueB()) {
            builder.append(String.format("/B: %s%n", difference.onlyInB()));
        }
        if (control.isShowBPercent()) {
            builder.append(String.format("%%/B: %s%n", difference.percentInB()));
        }
        if (control.isShowUnion()) {
            builder.append(String.format("A U B: %s%n", difference.union()));
        }
        if (control.isShowIntersection()) {
            builder.append(String.format("A ^ B: %s%n", difference.intersection()));
        }
        if (control.isShowJaccard()) {
            builder.append(String.format("Jaccard(A, B): %s%n", difference.jaccardSimilarity()));
        }
        if (control.isShowSD()) {
            builder.append(String.format("SD(A, B): %s%n", difference.sdSimilarity()));
        }
        if (control.isShowOverlap()) {
            builder.append(String.format("O(A, B): %s%n", difference.overlapSimilarity()));
        }

        return builder.toString();
    }

    private static class OutputControl {
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

        private File fileA;
        private File fileB;


        public File getFileA() {
            return fileA;
        }

        public File getFileB() {
            return fileB;
        }

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

        public void setFileA(File fileA) {
            this.fileA = fileA;
        }

        public void setFileB(File fileB) {
            this.fileB = fileB;
        }

        public static OutputControl defaultControl() {
            OutputControl c = new OutputControl();
            c.setShowA(true);
            c.setShowB(true);
            c.setShowIntersection(true);
            c.setShowOverlap(true);
            return c;
        }
    }
}
