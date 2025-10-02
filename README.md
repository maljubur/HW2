// HW2 – CRUD App

/**
 * run()
 * -----
 * Starts the console UI for CRUD on Questions and Answers.
 *
 * Preconditions:
 *   - Java 17
 *   - Eclipse (any) 
 *   - JUnit 5 (for tests)
 *
 * Build/Run (Eclipse):
 *   - Open project
 *   - Right-click Main → Run As → Java Application
 *
 * Build/Run (CLI, optional):
 *   mkdir -p out
 *   javac -d out $(find src -name "*.java")
 *   java -cp out edu.asu.cse360.hw2.Main
 *
 * Test (Eclipse):
 *   - Project → Properties → Java Build Path → Add Library → JUnit → JUnit 5
 *   - Right-click QuestionsAnswersTest → Run As → JUnit Test
 *
 * API (core types):
 *   class Question { int id; String text; /* throws if text blank */ }
 *   class Questions {
 *     void addQuestion(Question q);
 *     List<Question> getAllQuestions();
 *     boolean exists(int id);
 *     void update(int id, String newText);        // throws if blank/missing
 *     boolean removeQuestionIfPresent(int id);
 *   }
 *   class Answer { int questionId; String text; /* throws if text blank */ }
 *   class Answers {
 *     void addAnswer(Answer a);
 *     List<Answer> forQuestion(int qid);          // empty list if none
 *   }
 *
 * Console menu:
 *   1) Add Question
 *   2) View Questions
 *   3) Update Question
 *   4) Delete Question
 *   5) Add Answer
 *   6) List Answers for a Question
 *   0) Exit
 *
 * Errors (messages/throws):
 *   "Question cannot be empty"
 *   "Update failed: question cannot be empty"
 *   "Question not found."
 *   "No questions available."
 *   "Answer cannot be empty"
 *   "No answers available."
 *
 * Files (src):
 *   edu/asu/cse360/hw2/Main.java
 *   edu/asu/cse360/hw2/Question.java
 *   edu/asu/cse360/hw2/Questions.java
 *   edu/asu/cse360/hw2/Answer.java
 *   edu/asu/cse360/hw2/Answers.java
 *   edu/asu/cse360/hw2/test/QuestionsAnswersTest.java
 *
 * Notes:
 *   - Delete module-info.java if modules cause classpath issues.
 *   - Keep bin/, out/, target/ out of git.
 */
