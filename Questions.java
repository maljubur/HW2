package edu.asu.cse360.hw2;

import java.util.*;

public class Questions {
    private final Map<Integer, Question> byId = new LinkedHashMap<>();

    public void addQuestion(Question q) { byId.put(q.id, q); }

    public List<Question> getAllQuestions() {
        return new ArrayList<>(byId.values());
    }

    public boolean exists(int id) { return byId.containsKey(id); }

    public void update(int id, String newText) {
        if (newText == null || newText.isBlank())
            throw new IllegalArgumentException("Update failed: question cannot be empty");
        if (!byId.containsKey(id))
            throw new IllegalArgumentException("Question not found.");
        byId.put(id, new Question(id, newText));
    }

    public boolean removeQuestionIfPresent(int id) {
        return byId.remove(id) != null;
    }
}
