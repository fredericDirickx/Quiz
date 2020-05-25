package be.intecbrussel.quize.model;

import be.intecbrussel.quize.QuizQuestion;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.util.*;

import static be.intecbrussel.quize.view.ConsoleColors.*;
import static java.time.LocalDateTime.now;

@Entity
public class QuizService {
    //___________________________________________________properties

    @Id
    @GeneratedValue
    private long id;
    @OneToOne
    private User user = new User();
    private LocalDate date = LocalDate.now();
    private boolean IsAddition;
    private boolean IsSubtraction;
    private boolean IsMultiplication;
    private boolean IsDivision;
    private int amountQuestions = 10;

    private int totalGoodQuestions;
    private double totalPercent;
    private Duration totalTime = Duration.ofSeconds(0);

    @Transient
    private ArrayList<Double> userAnswers = new ArrayList<>();
    @Transient
    private ArrayList<Temporal> startTimes = new ArrayList<>();
    @Transient
    private ArrayList<Temporal> endTimes = new ArrayList<>();
    @OneToMany
    private List<Question> questions = new ArrayList<>();

    @Transient
    private int lastQuestionNr;
    @Transient
    private NumberGenerator numberGenerator = new NumberGenerator(1,10,1,10);

    //___________________________________________________constructors
    public QuizService() {
    }

    //___________________________________________________getters & setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isIsAddition() {
        return IsAddition;
    }

    public void setIsAddition(boolean addition) {
        this.IsAddition = addition;
    }

    public boolean isIsSubtraction() {
        return IsSubtraction;
    }

    public void setIsSubtraction(boolean subtraction) {
        this.IsSubtraction = subtraction;
    }

    public boolean isIsMultiplication() {
        return IsMultiplication;
    }

    public void setIsMultiplication(boolean multiplication) {
        this.IsMultiplication = multiplication;
    }

    public boolean isIsDivision() {
        return IsDivision;
    }

    public void setIsDivision(boolean division) {
        this.IsDivision = division;
    }

    public int getAmountQuestions() {
        return amountQuestions;
    }

    public void setAmountQuestions(int amountQuestions) {
        this.amountQuestions = amountQuestions;
    }

    public int getTotalGoodQuestions() {
        return totalGoodQuestions;
    }

    public void setTotalGoodQuestions(int totalGoodQuestions) {
        this.totalGoodQuestions = totalGoodQuestions;
    }

    public double getTotalPercent() {
        return totalPercent;
    }

    public void setTotalPercent(double totalPercent) {
        this.totalPercent = totalPercent;
    }

    public Duration getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Duration totalTime) {
        this.totalTime = totalTime;
    }

    public ArrayList<Double> getUserAnswers() {
        return userAnswers;
    }

    public void setUserAnswers(ArrayList<Double> userAnswers) {
        this.userAnswers = userAnswers;
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

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }


    public int getLastQuestionNr() {
        return lastQuestionNr;
    }

    public void setLastQuestionNr(int lastQuestionNr) {
        this.lastQuestionNr = lastQuestionNr;
    }

    public NumberGenerator getNumberGenerator() {
        return numberGenerator;
    }

    public void setNumberGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }


    //___________________________________________________methods

    //will create the quiz: fill the questions list based on constructor parameters
    public void createQuiz() {

        Operations operations = new Operations();

        int[] arr = operations.operations;

        Random number = new Random();

        int boundQuestions = 0;

        boundQuestions += this.IsAddition ? 1 : 0;
        boundQuestions += this.IsSubtraction ? 1 : 0;
        boundQuestions += this.IsMultiplication ? 1 : 0;
        boundQuestions += this.IsDivision ? 1 : 0;


        for (int i = 0; i < amountQuestions; i++) {

            int operation = arr[number.nextInt(boundQuestions)]; //get random number to switch randomly between addition
            // and subtraction


            if (operation == 0) {
                AdditionQuestion addQuestion = new AdditionQuestion();
                addQuestion.setFirstNumber(numberGenerator.getFirstNumber());
                addQuestion.setSecondNumber(numberGenerator.getSecondNumber());
                questions.add(addQuestion);
            } else if (operation == 1) {
                SubtractionQuestion subQuestion = new SubtractionQuestion();
                subQuestion.setFirstNumber(numberGenerator.getFirstNumber());
                subQuestion.setSecondNumber(numberGenerator.getSecondNumber());
                questions.add(subQuestion);
            } else if (operation == 2) {
                MultiplicationQuestion mulQuestion = new MultiplicationQuestion();
                mulQuestion.setFirstNumber(numberGenerator.getFirstNumber());
                mulQuestion.setSecondNumber(numberGenerator.getSecondNumber());
                questions.add(mulQuestion);
            } else if (operation == 3) {
                DivisionQuestion divQuestion = new DivisionQuestion();
                if (numberGenerator.mostDecimals() > 0) {
                    divQuestion.setFirstNumber(numberGenerator.getFirstNumber());
                    divQuestion.setSecondNumber(numberGenerator.getSecondNumber());
                } else {
                    double[] numbers = numberGenerator.getIntegersForDivQuestion();
                    divQuestion.setFirstNumber(numbers[0]);
                    divQuestion.setSecondNumber(numbers[1]);
                }
                questions.add(divQuestion);
            }

        }

    }


    //inner class that will control the operations of the quiz based on constructor of QuizService
    public class Operations {
        //array of the different operations of the quiz
        //Can be different options depending on what is set when QuizService is initialized
        int[] operations = new int[0];

        public Operations() {

            if (!IsAddition && !IsDivision && !IsMultiplication && !IsSubtraction) {
                IsAddition = true;
            }

            if (IsAddition) {
                addNumberToArr(0);
            }
            if (IsSubtraction) {
                addNumberToArr(1);
            }
            if (IsMultiplication) {
                addNumberToArr(2);
            }
            if (IsDivision) {
                addNumberToArr(3);
            }

        }


        private void addNumberToArr(int x) {
            this.operations = Arrays.copyOf(this.operations, this.operations.length + 1);
            this.operations[this.operations.length - 1] = x;
        }

    }


}


