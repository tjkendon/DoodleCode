package ca.kendon.competitionrank;

public class ManualDriver {

    public static void main (String[] args) {


        Option a = new Option("Course A");
        Option b = new Option("Course B");
        Option c = new Option("Course C");
        Option d = new Option("Course D");

        CompetitionRound test1 = new CompetitionRound();
        test1.putOption(a, 6);
        test1.putOption(b, 3);
        test1.putOption(c, 2);
        test1.putOption(d, 1);

        System.out.println(test1.getOptions());
        System.out.println(test1.getRanked());


    }

}