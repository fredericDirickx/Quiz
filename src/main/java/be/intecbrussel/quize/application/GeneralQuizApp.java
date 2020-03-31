package be.intecbrussel.quize.application;

import be.intecbrussel.quize.model.NumberGenerator;
import be.intecbrussel.quize.model.QuizService;


import java.util.Scanner;

public class GeneralQuizApp {
    public static void main(String[] args) {


        NumberGenerator numberGenerator = new NumberGenerator(0.0,1.9,0.0,1.9);
        QuizService quizService = null;
            quizService = new QuizService(2,true,false,false,false,numberGenerator);


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
