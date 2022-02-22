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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Response response = (Response) o;

        if (question != null ? !question.equals(response.question) : response.question != null) return false;
        return choice != null ? choice.equals(response.choice) : response.choice == null;
    }

    @Override
    public int hashCode() {
        int result = question != null ? question.hashCode() : 0;
        result = 71 * result + (choice != null ? choice.hashCode() : 0);
        return result;
    }

}
