package edu.asu.cse360.hw2.test;

import edu.asu.cse360.hw2.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class QuestionsAnswersTest {
  @Test void addQuestion_success() {
    Questions qs = new Questions();
    qs.addQuestion(new Question(1, "What is CRUD?"));
    assertEquals(1, qs.getAllQuestions().size());
  }

  @Test void addQuestion_empty_throws() {
    assertThrows(IllegalArgumentException.class, () -> new Question(1, " "));
  }

  @Test void listQuestions_empty() {
    assertTrue(new Questions().getAllQuestions().isEmpty());
  }

  @Test void update_success() {
    Questions qs = new Questions();
    qs.addQuestion(new Question(1, "old"));
    qs.update(1, "new");
    assertEquals("new", qs.getAllQuestions().get(0).text);
  }

  @Test void update_empty_throws() {
    Questions qs = new Questions();
    qs.addQuestion(new Question(1, "q"));
    assertThrows(IllegalArgumentException.class, () -> qs.update(1, ""));
  }

  @Test void update_missing_throws() {
    assertThrows(IllegalArgumentException.class, () -> new Questions().update(99, "x"));
  }

  @Test void delete_ok_and_missing() {
    Questions qs = new Questions();
    qs.addQuestion(new Question(1, "q"));
    assertTrue(qs.removeQuestionIfPresent(1));
    assertFalse(qs.removeQuestionIfPresent(1));
  }

  @Test void answers_add_and_list() {
    Answers as = new Answers();
    as.addAnswer(new Answer(5, "a1"));
    as.addAnswer(new Answer(5, "a2"));
    assertEquals(2, as.forQuestion(5).size());
    assertTrue(as.forQuestion(7).isEmpty());
  }

  @Test void answer_empty_throws() {
    assertThrows(IllegalArgumentException.class, () -> new Answer(1, " "));
  }
}
