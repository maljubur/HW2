package edu.asu.cse360.hw2;

public class Answer {
    public final int questionId;
    public final String text;

    public Answer(int questionId, String text) {
        if (text == null || text.isBlank())
            throw new IllegalArgumentException("Answer cannot be empty");
        this.questionId = questionId;
        this.text = text;
    }

    @Override public String toString() { return "[" + questionId + "] " + text; }
}
