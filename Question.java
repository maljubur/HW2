package edu.asu.cse360.hw2;

public class Question {
    public final int id;
    public final String text;

    public Question(int id, String text) {
        if (text == null || text.isBlank())
            throw new IllegalArgumentException("Question cannot be empty");
        this.id = id;
        this.text = text;
    }

    @Override public String toString() { return id + ": " + text; }
}
