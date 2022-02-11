package ca.kendon.categoryvote;

public class Response {

    private final Question question;
    private final Option choice;

    public Response(Question question, Option choice) {
        this.question = question;
        this.choice = choice;
    }

    public Question getQuestion() {
        return question;
    }

    public Option getChoice() {
        return choice;
    }
}
