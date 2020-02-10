package be.intecbrussel.quize.implementation;
import be.intecbrussel.quize.QuizQuestion;

import java.util.Formatter;

public class AdditionQuestion<T extends Number> implements QuizQuestion {
    //___________________________________________________properties
    private double firstNumber;
    private double secondNumber;

    //___________________________________________________constructors
    public AdditionQuestion(T firstNumber, T secondNumber){
        this.firstNumber = firstNumber.doubleValue();
        this.secondNumber = secondNumber.doubleValue();
    }

    //___________________________________________________methods
    @Override
    public double getCorrectAnswer() {
        return  firstNumber + secondNumber;
    }

    @Override
    public String getQuestion() {
        return  QuizQuestion.question("+",firstNumber,secondNumber);
    }

}
