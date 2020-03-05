package be.intecbrussel.quize.implementation;
import be.intecbrussel.quize.QuizQuestion;

import java.io.Serializable;
import java.util.Formatter;

public class SubtractionQuestion<T extends Number> implements QuizQuestion, Serializable {
    //___________________________________________________properties
    private double firstNumber;
    private double secondNumber;

    //___________________________________________________constructors
    public SubtractionQuestion(T firstNumber, T secondNumber){
        this.firstNumber = Math.max(firstNumber.doubleValue(), secondNumber.doubleValue());
        this.secondNumber = Math.min(firstNumber.doubleValue(), secondNumber.doubleValue());
    }

    //___________________________________________________methods
    @Override
    public double getCorrectAnswer() {
        return firstNumber - secondNumber;
    }

    @Override
    public String getQuestion() {
        return  QuizQuestion.question("-",firstNumber,secondNumber);
    }



}
