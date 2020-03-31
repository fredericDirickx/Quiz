package be.intecbrussel.quize.application;

import be.intecbrussel.quize.implementation.NumberGenerator;
import be.intecbrussel.quize.implementation.QuizService;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class GeneralQuizApp {
    public static void main(String[] args) {


        NumberGenerator numberGenerator = new NumberGenerator(8,9,0.0,11.0);
        QuizService quizService = null;
            quizService = new QuizService(100,false,false,true,false,numberGenerator);


        Scanner input = new Scanner(System.in);
        String enGame = "y";



        while (enGame.equals("y")) {

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
