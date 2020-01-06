package be.intecbrussel.quize.application;

import be.intecbrussel.quize.implementation.QuizService;

public class GeneralQuizApp {
    public static void main(String[] args) {
        QuizService quizService = new QuizService();

        System.out.println("Welcome to the quiz\n");
        System.out.println("There are 10 addition/substraction questions, " +
                "\nthe answer to every question is an integer\n");

        quizService.createQuiz();
        quizService.administrateQuiz();
        quizService.gradeQuiz();
    }
}
