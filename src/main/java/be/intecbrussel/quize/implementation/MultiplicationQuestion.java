package be.intecbrussel.quize.implementation;

import be.intecbrussel.quize.QuizQuestion;

import java.io.Serializable;
import java.util.Formatter;

public class MultiplicationQuestion <T extends Number> implements QuizQuestion {

    private double firstNumber;
    private double secondNumber;

    public MultiplicationQuestion(T firstNumber,T secondNumber){
        this.firstNumber = firstNumber.doubleValue();
        this.secondNumber = secondNumber.doubleValue();
    }

    @Override
    public double getCorrectAnswer() {
        return firstNumber * secondNumber;
    }

    @Override
    public String getQuestion() {
        return  QuizQuestion.question("x",firstNumber,secondNumber);
    }
}
