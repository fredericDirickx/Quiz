package be.intecbrussel.quize.application;

import be.intecbrussel.quize.implementation.LoadData;
import be.intecbrussel.quize.implementation.NumberGenerator;
import be.intecbrussel.quize.implementation.QuizService;
import be.intecbrussel.quize.implementation.SafeData;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class GeneralQuizApp {
    public static void main(String[] args) {

        String user = "Charlie";
        Path path = Paths.get("C:\\Users\\Frederic\\IdeaProjects\\Quiz\\data");
        LoadData load = new LoadData(user,path);
        NumberGenerator<Number> numberGenerator = new NumberGenerator<Number>(3,10,0,10);
        QuizService<Number> quizService = null;

        if(Files.notExists(path.resolve("\\"+user))){
            quizService = new QuizService<Number>(2,false,false,true,false,numberGenerator);
        }else{
           quizService = (QuizService<Number>) load.loadQuize();
           quizService.gradeQuiz();
        }


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


        SafeData safeData = new SafeData(quizService,user,path);
        safeData.safeToDrive();
        System.out.println("SEE YOU NEXT TIME!!!!!");



    }
}
