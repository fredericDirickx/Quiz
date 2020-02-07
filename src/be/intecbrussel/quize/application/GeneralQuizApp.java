package be.intecbrussel.quize.application;

import be.intecbrussel.quize.implementation.NumberGenerator;
import be.intecbrussel.quize.implementation.QuizService;

import java.util.Scanner;

public class GeneralQuizApp {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String enGame = "y";
        NumberGenerator numberGenerator = new NumberGenerator(0,10);

        while (enGame.equals("y")) {
            QuizService quizService = new QuizService(10,false,false,true,false,numberGenerator);
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
