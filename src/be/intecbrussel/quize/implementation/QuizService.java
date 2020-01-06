package be.intecbrussel.quize.implementation;

import be.intecbrussel.quize.QuizQuestion;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class QuizService {
    //___________________________________________________properties
    private Scanner input = new Scanner(System.in);
    private QuizQuestion[] questions = new QuizQuestion[10];
    private int[] userAnswers = new int[10];

    //___________________________________________________constructors
    public QuizService(){}

    //___________________________________________________methods
    public void createQuiz(){
        int i = 0; //for index of the array when looping through it.
        Random number = new Random(); //make a new random object to get random numbers for the quiz.

     for(QuizQuestion q : this.questions){

         int sumOrsub = number.nextInt(2); //get random number to switch randomly between addition
                                                  // and subtraction

         if(sumOrsub == 0) {
             questions[i] = new AdditionQuestion(number.nextInt(11), number.nextInt(11));
         }
         else {
             questions[i] = new SubtractionQuestion(number.nextInt(11), number.nextInt(11));
         }
         i++;
     }

    }

    //get the answer of the user and repeat if when input is not a integer.
    private int getInput(){
        int answer = 0;
        boolean repeat = true;
        do {
            System.out.println("enter your answer");
            try {
                answer = this.input.nextInt();
                repeat = false;
            } catch (InputMismatchException e) {
                System.out.println("please enter a integer number");
                input.next();
            }


        }while (repeat);



        return answer;
    }

    //asks the user the questions and enters the input of the user
   public void administrateQuiz(){
        int i = 0;
       for (QuizQuestion q: this.questions) {

           System.out.println(q.getQuestion());
           this.userAnswers[i] = getInput();
           i++;
       }
   }

   //prints the questions of the quiz, the answers of the user, the correct answers and
   //if the answer of the user was correct.
   //also prints how many answers where correct.
    public void gradeQuiz(){
        System.out.printf("%-15s %-15s %-15s %-15s %n","Question","Your answer", "Correct answer", "Result");
        int i = 0;
        String result = "";
        int goodResults = 0;
        for (QuizQuestion q: this.questions) {

            if(userAnswers[i]==q.getCorrectAnswer()){
                result = "correct";
                goodResults++;
            }
            else{
                result = "wrong";
            }
            System.out.printf("%-15s %-15d %-15d %-15s %n",q.getQuestion(),userAnswers[i], q.getCorrectAnswer(),result);
            i++;
        }
        System.out.println("you have " + goodResults + " correct answers out of 10");

    }

}
