package be.intecbrussel.quize.implementation;

import be.intecbrussel.quize.QuizQuestion;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import static be.intecbrussel.quize.implementation.ConsoleColors.*;


public class QuizService {
    //___________________________________________________properties
    private Scanner input = new Scanner(System.in);
    private QuizQuestion[] questions;
    private boolean addition = true;
    private boolean subtraction = true;
    private boolean multiplication = true;
    private boolean division = true;
    private int amountQuestions = 10;
    private int[] userAnswers;
    private int bound;
    public static int totalGoodQuestions;
    public static int totalQuestions;
    public static double totalPercent;

    //___________________________________________________constructors


    public QuizService(boolean addition, boolean subtraction, boolean multiplication, boolean division, int amountQuestions, int bound) {
        this.addition = addition;
        this.subtraction = subtraction;
        this.multiplication = multiplication;
        this.division = division;
        this.amountQuestions = amountQuestions;
        this.bound = bound;
        this.userAnswers = new int[amountQuestions];
        this.questions =  new QuizQuestion[amountQuestions];
    }


    public boolean isAddition() {
        return addition;
    }

    public void setAddition(boolean addition) {
        this.addition = addition;
    }

    public boolean isSubtraction() {
        return subtraction;
    }

    public void setSubtraction(boolean subtraction) {
        this.subtraction = subtraction;
    }

    public boolean isMultiplication() {
        return multiplication;
    }

    public void setMultiplication(boolean multiplication) {
        this.multiplication = multiplication;
    }

    public boolean isDivision() {
        return division;
    }

    public void setDivision(boolean division) {
        this.division = division;
    }

    public int getAmountQuestions() {
        return amountQuestions;
    }

    public void setAmountQuestions(int amountQuestions) {
        this.amountQuestions = amountQuestions;
    }

    //___________________________________________________methods
    public void createQuiz(){

        Operations operations = new Operations();

        System.out.println("We have " + amountQuestions +" "+operations.operationName()+" operations for you");

        int[] arr = operations.operations;

        int i = 0; //for index of the array when looping through it.
        Random number = new Random(); //make a new random object to get random numbers for the quiz.

        int boundQuestions = 0;

        boundQuestions += this.addition? 1:0;
        boundQuestions += this.subtraction? 1:0;
        boundQuestions += this.multiplication? 1:0;
        boundQuestions += this.division? 1:0;



     for(QuizQuestion q : this.questions){

         int operation = arr[number.nextInt(boundQuestions)]; //get random number to switch randomly between addition
                                                  // and subtraction

         if(operation == 0) {
             questions[i] = new AdditionQuestion(number.nextInt(this.bound), number.nextInt(this.bound));
         }
         else if(operation ==1){
             questions[i] = new SubtractionQuestion(number.nextInt(this.bound), number.nextInt(this.bound));
         }
         else if(operation == 2){
             questions[i] = new MultiplicationQuestion(number.nextInt(this.bound), number.nextInt(this.bound));
         }
         else if(operation == 3) {
             questions[i] = new DivisionQuestion(number.nextInt(this.bound-1)+1, number.nextInt(this.bound-1)+1);
         }
         i++;
     }

    }

    public class Operations {
        int[] operations = new int[0];
        public Operations() {

            if (!addition && !division && !multiplication && !subtraction) {
                addition = true;
            }

            if (addition) {
                addNumberToArr(0);
            }
            if (subtraction) {
                addNumberToArr(1);
            }
            if (multiplication) {
                addNumberToArr(2);
            }
            if (division) {
                addNumberToArr(3);
            }

        }

        private String operationName(){
            String operations = "";
            String delimiter = "";
            boolean more = false;
            if (addition) {
                delimiter = more? ", ":"";
                operations += delimiter + "addition";
                more = true;
            }
            if (subtraction) {
                delimiter = more? ", ":"";
                operations += delimiter + "subtraction";
                more = true;
            }
            if (multiplication) {
                delimiter = more? ", ":"";
                operations += delimiter + "multiplication";
                more = true;
            }
            if (division) {
                delimiter = more? ", ":"";
                operations += delimiter + "division";
                more = true;
            }
            return operations;
        }

        private void addNumberToArr(int x) {
            this.operations = Arrays.copyOf(this.operations, this.operations.length + 1);
            this.operations[this.operations.length - 1] = x;
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
        System.out.printf(CYAN_BOLD+CYAN_UNDERLINED+"%-15s %-15s %-15s %-15s"+RESET+"%n","Question","Your answer", "Correct", "Result");
        String alternatingColor = "";
        int i = 0;
        String result = "";
        int goodResults = 0;
        for (QuizQuestion q: this.questions) {

            if(userAnswers[i]==q.getCorrectAnswer()){
                result = GREEN_BOLD+"correct"+RESET;
                goodResults++;
            }
            else{
                result = RED+"wrong"+RESET;
            }


                alternatingColor = i%2==0? CYAN_BACKGROUND:WHITE;


            System.out.printf(alternatingColor+"%-15s %-15d %-15d %-15s"+RESET+"%n",q.getQuestion(),userAnswers[i], q.getCorrectAnswer(),result);
            i++;
        }


        totalGoodQuestions += goodResults;
        totalQuestions += this.amountQuestions;
        totalPercent = ((double) totalGoodQuestions/ (double) totalQuestions)*100;

        System.out.println(CYAN_UNDERLINED+"you have " + goodResults + " correct answers out of "+ this.amountQuestions+RESET );
        System.out.printf( CYAN_BACKGROUND+"You have: "+GREEN_BOLD+" %.0f %%"+RESET+"%n" , (double)((double)goodResults/(double)this.amountQuestions)*100 );


        System.out.println("\n"+CYAN_BOLD+"*****TOTAL*****"+RESET);
        System.out.println(CYAN_UNDERLINED+"you have " + totalGoodQuestions + " correct answers out of "+ totalQuestions+RESET );
        System.out.printf( CYAN_BACKGROUND+"You have: "+GREEN_BOLD+" %.0f %%"+RESET+"%n" , totalPercent );




    }

}