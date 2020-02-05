package be.intecbrussel.quize.application;

import be.intecbrussel.quize.implementation.QuizService;

import java.util.Scanner;

public class GeneralQuizApp {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String enGame = "y";

        while (enGame.equals("y")) {
            QuizService quizService = new QuizService(false,false,true,false,10,3,5,0,10);
            System.out.println("Welcome to the quiz\n");
            quizService.createQuiz();
            quizService.administrateQuiz();
            quizService.gradeQuiz();

            System.out.println("Do you want to play again? y or n ?");
            enGame = input.next();

        }

        System.out.println("SEE YOU NEXT TIME!!!!!");
    }
}
