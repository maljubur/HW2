package edu.asu.cse360.hw2;

import java.util.*;

public class Answers {
    private final Map<Integer, List<Answer>> map = new HashMap<>();

    public void addAnswer(Answer a) {
        map.computeIfAbsent(a.questionId, k -> new ArrayList<>()).add(a);
    }

    public List<Answer> forQuestion(int qid) {
        return map.getOrDefault(qid, Collections.emptyList());
    }
}
