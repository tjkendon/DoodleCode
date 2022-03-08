package ca.kendon.categoryvote;

import org.jetbrains.annotations.NotNull;

/**
 *
 * Records which option a person chose for a given question.
 *
 */
public class Response {

    /**
     * The question being answered
     */
    private final Question question;
    /**
     * The selected Option
     */
    private final Option choice;

    /**
     *
     * Creates a new response with the given question and selected option.
     *
     * @param question the question the choice is for
     * @param choice the option which was chosen
     */
    public Response(@NotNull Question question, Option choice) {
        if (question.getOptions().contains(choice)) {
            this.question = question;
            this.choice = choice;
        }
        throw new IllegalArgumentException("Choice must be an option of question" + question + ":" +choice);
    }

    /**
     *
     * Returns the question the choice is for.
     *
     * @return the question the choice is for.
     */
    public Question getQuestion() {
        return question;
    }

    /**
     *
     * Returns the chosen option.
     *
     * @return the chosen option
     */
    public Option getChoice() {
        return choice;
    }

    @Override
    public String toString() {
        return "Response{" +
                "question=" + question +
                ", choice=" + choice +
                '}';
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
