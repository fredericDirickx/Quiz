package be.intecbrussel.quize.implementation;

import be.intecbrussel.quize.QuizQuestion;

import java.io.Serializable;
import java.time.Duration;
import java.time.temporal.Temporal;
import java.util.*;

import static be.intecbrussel.quize.implementation.ConsoleColors.*;
import static java.time.LocalDateTime.now;


public class QuizService <T extends Number> {
    //___________________________________________________properties

    private boolean addition = true;
    private boolean subtraction = true;
    private boolean multiplication = true;
    private boolean division = true;
    private NumberGenerator<T> numberGenerator;



    private int amountQuestions = 10;
    private  ArrayList<Double> userAnswers = new ArrayList<>();
    private  Scanner input = new Scanner(System.in);
    private  ArrayList<QuizQuestion<T>> questions = new ArrayList<>();
    public static int totalGoodQuestions;
    public static int totalQuestions;
    public static double totalPercent;
    private  ArrayList<Temporal> startTimes = new ArrayList<>();
    private  ArrayList<Temporal> endTimes = new ArrayList<>();
    private static Duration totalTime = Duration.ofSeconds(0);
    private static int lastQuestionNr;

    //___________________________________________________constructors
    public QuizService(int amountQuestions, boolean addition, boolean subtraction, boolean multiplication, boolean division, NumberGenerator<T> numberGenerator) {
        this.amountQuestions = amountQuestions;
        this.addition = addition;
        this.subtraction = subtraction;
        this.multiplication = multiplication;
        this.division = division;
        this.numberGenerator = numberGenerator;
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


    public NumberGenerator<T> getNumberGenerator() {
        return numberGenerator;
    }

    public void setNumberGenerator(NumberGenerator<T> numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public ArrayList<Double> getUserAnswers() {
        return userAnswers;
    }

    public void setUserAnswers(ArrayList<Double> userAnswers) {
        this.userAnswers = userAnswers;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public ArrayList<QuizQuestion<T>> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<QuizQuestion<T>> questions) {
        this.questions = questions;
    }

    public static int getTotalGoodQuestions() {
        return totalGoodQuestions;
    }

    public static void setTotalGoodQuestions(int totalGoodQuestions) {
        QuizService.totalGoodQuestions = totalGoodQuestions;
    }

    public static int getTotalQuestions() {
        return totalQuestions;
    }

    public static void setTotalQuestions(int totalQuestions) {
        QuizService.totalQuestions = totalQuestions;
    }

    public static double getTotalPercent() {
        return totalPercent;
    }

    public static void setTotalPercent(double totalPercent) {
        QuizService.totalPercent = totalPercent;
    }

    public ArrayList<Temporal> getStartTimes() {
        return startTimes;
    }

    public void setStartTimes(ArrayList<Temporal> startTimes) {
        this.startTimes = startTimes;
    }

    public ArrayList<Temporal> getEndTimes() {
        return endTimes;
    }

    public void setEndTimes(ArrayList<Temporal> endTimes) {
        this.endTimes = endTimes;
    }

    public static Duration getTotalTime() {
        return totalTime;
    }

    public static void setTotalTime(Duration totalTime) {
        QuizService.totalTime = totalTime;
    }

    public static int getLastQuestionNr() {
        return lastQuestionNr;
    }

    public static void setLastQuestionNr(int lastQuestionNr) {
        QuizService.lastQuestionNr = lastQuestionNr;
    }

    //___________________________________________________methods
    public void createQuiz(){

        Operations operations = new Operations();

        System.out.println("We have " + amountQuestions +" "+operations.operationName()+" operations for you");

        int[] arr = operations.operations;

        Random number = new Random();

        int boundQuestions = 0;

        boundQuestions += this.addition? 1:0;
        boundQuestions += this.subtraction? 1:0;
        boundQuestions += this.multiplication? 1:0;
        boundQuestions += this.division? 1:0;



     for(int i = 0 ; i < amountQuestions; i++){

         int operation = arr[number.nextInt(boundQuestions)]; //get random number to switch randomly between addition
                                                  // and subtraction


         if(operation == 0) {
             questions.add(new AdditionQuestion<T>(numberGenerator.getFirstNumber(), numberGenerator.getSecondNumber()));
         }
         else if(operation ==1){
             questions.add(new SubtractionQuestion(numberGenerator.getFirstNumber(), numberGenerator.getSecondNumber()));
         }
         else if(operation == 2){
             questions.add(new MultiplicationQuestion(numberGenerator.getFirstNumber(), numberGenerator.getSecondNumber()));
         }
         else if(operation == 3) {
             questions.add(new DivisionQuestion(numberGenerator.getFirstNumber(), numberGenerator.getSecondNumber()));
         }

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
    private double getInput(){
        double answer = 0;
        boolean repeat = true;
        do {
            System.out.println("enter your answer");
            try {
                answer = this.input.nextDouble();
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

       for (int i = lastQuestionNr ; i < this.questions.size() ; i++) {
            this.startTimes.add(now());
           System.out.println(this.questions.get(i).getQuestion());
           this.userAnswers.add((double) getInput());
           this.endTimes.add(now());
       }
       lastQuestionNr = questions.size();
   }


   //prints the questions of the quiz, the answers of the user, the correct answers and
   //if the answer of the user was correct.
   //also prints how many answers where correct.
    public void gradeQuiz(){
        System.out.printf(CYAN_BOLD+CYAN_UNDERLINED+"%-20s%-20s%-20s%-20s%-20s%n"+RESET,"Question","Your answer", "Correct", "Time", "Result");
        String alternatingColor = "";
        int i = 0;
        String result = "";
        int goodResults = 0;

        Duration totalDuration = Duration.between(startTimes.get(i), endTimes.get(amountQuestions-1));
        totalTime = totalTime.plus(totalDuration);

        for (QuizQuestion q: this.questions) {

            if(userAnswers.get(i)==q.getCorrectAnswer()){
                result = GREEN_BOLD+"correct"+RESET;
                goodResults++;
            }
            else{
                result = RED+"wrong"+RESET;
            }


                alternatingColor = i%2==0? CYAN_BACKGROUND:WHITE;


            Duration questionD = Duration.between(startTimes.get(i), endTimes.get(i));
            String time = questionD.toMinutes() +" min "+questionD.toSecondsPart()+" sec";
            System.out.printf(alternatingColor+"%-20s" +
                    "%-20"+QuizQuestion.floatSwitch(userAnswers.get(i))+"f" +
                    "%-20"+QuizQuestion.floatSwitch(q.getCorrectAnswer())+"f" +
                            "%-20s%-20s%n"+RESET,
                    q.getQuestion(),userAnswers.get(i), q.getCorrectAnswer(),time,result);
            i++;
        }


        totalGoodQuestions += goodResults;
        totalQuestions += this.amountQuestions;
        totalPercent = ((double) totalGoodQuestions/ (double) totalQuestions)*100;

        System.out.println(CYAN_UNDERLINED+"you have " + goodResults + " correct answers out of "+ this.amountQuestions+RESET );
        System.out.printf( CYAN_BACKGROUND+"You have: "+GREEN_BOLD+" %.0f %%"+RESET+"%n" , (double)((double)goodResults/(double)this.amountQuestions)*100 );
        System.out.println(CYAN_UNDERLINED+"You did all of this in: "+ totalDuration.toMinutesPart()+ " min " + totalDuration.toSecondsPart()+ " sec"+RESET);


        System.out.println("\n"+CYAN_BOLD+"*****TOTAL*****"+RESET);
        System.out.println(CYAN_UNDERLINED+"you have " + totalGoodQuestions + " correct answers out of "+ totalQuestions+RESET );
        System.out.printf( CYAN_BACKGROUND+"You have: "+GREEN_BOLD+" %.0f %%"+RESET+"%n" , totalPercent );
        System.out.println(CYAN_UNDERLINED+"Total time: "+ totalTime.toMinutesPart()+ " min " + totalTime.toSecondsPart()+ " sec"+RESET);

    }



}
