package be.intecbrussel.quize.implementation;

import be.intecbrussel.quize.QuizQuestion;

public class MultiplicationQuestion <T extends Number> implements QuizQuestion {

    private double firstNumber;
    private double secondNumber;

    public MultiplicationQuestion(T firstNumber,T secondNumber){
        this.firstNumber = firstNumber.doubleValue();
        this.secondNumber = secondNumber.doubleValue();
    }


    @Override
    public String getQuestion() {
        return firstNumber + " x " + secondNumber;
    }

    @Override
    public double getCorrectAnswer() {
        return firstNumber * secondNumber;
    }
}
