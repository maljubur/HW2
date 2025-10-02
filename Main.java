package edu.asu.cse360.hw2;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Questions questions = new Questions();
        Answers answers = new Answers();
        Scanner in = new Scanner(System.in);
        int nextQid = 1;

        while (true) {
            System.out.println("\n1) Add Question");
            System.out.println("2) View Questions");
            System.out.println("3) Update Question");
            System.out.println("4) Delete Question");
            System.out.println("5) Add Answer");
            System.out.println("6) List Answers for a Question");
            System.out.println("0) Exit");
            System.out.print("Choose: ");
            String s = in.nextLine().trim();
            int choice = s.isEmpty() ? -1 : parseInt(s);

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter question text: ");
                    String text = in.nextLine();
                    try {
                        questions.addQuestion(new Question(nextQid++, text));
                        System.out.println("Question added.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 2 -> {
                    List<Question> all = questions.getAllQuestions();
                    if (all.isEmpty()) System.out.println("No questions available.");
                    else all.forEach(System.out::println);
                }
                case 3 -> {
                    System.out.print("Enter question ID to update: ");
                    int id = parseInt(in.nextLine());
                    if (!questions.exists(id)) { System.out.println("Question not found."); break; }
                    System.out.print("Enter new text: ");
                    String nt = in.nextLine();
                    try {
                        questions.update(id, nt);
                        System.out.println("Updated.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 4 -> {
                    System.out.print("Enter question ID to delete: ");
                    int id = parseInt(in.nextLine());
                    System.out.println(questions.removeQuestionIfPresent(id) ? "Removed." : "Question not found.");
                }
                case 5 -> {
                    System.out.print("Enter question ID to answer: ");
                    int qid = parseInt(in.nextLine());
                    if (!questions.exists(qid)) { System.out.println("Question not found."); break; }
                    System.out.print("Enter answer text: ");
                    String at = in.nextLine();
                    try {
                        answers.addAnswer(new Answer(qid, at));
                        System.out.println("Answer added.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 6 -> {
                    System.out.print("Enter question ID: ");
                    int qid = parseInt(in.nextLine());
                    var list = answers.forQuestion(qid);
                    if (list.isEmpty()) System.out.println("No answers available.");
                    else list.forEach(System.out::println);
                }
                case 0 -> { System.out.println("Bye"); return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static int parseInt(String s) {
        try { return Integer.parseInt(s.trim()); } catch (Exception e) { return -1; }
    }
}
