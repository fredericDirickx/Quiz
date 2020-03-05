package be.intecbrussel.quize.implementation;

import be.intecbrussel.quize.QuizQuestion;

import java.io.Serializable;
import java.util.Formatter;

public class DivisionQuestion <T extends Number> implements QuizQuestion, Serializable {

    private double firstNumber;
    private double secondNumber;

    public DivisionQuestion(T firstNumber, T secondNumber){
        this.firstNumber = Math.max(firstNumber.doubleValue(), secondNumber.doubleValue());
        this.secondNumber = Math.min(firstNumber.doubleValue(), secondNumber.doubleValue());
        this.secondNumber += this.secondNumber<0? 1:0;

    }

    @Override
    public double getCorrectAnswer() {
        return firstNumber / secondNumber;
    }

    @Override
    public String getQuestion() {
        return  QuizQuestion.question(":",firstNumber,secondNumber);
    }
}
