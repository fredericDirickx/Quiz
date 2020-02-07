package be.intecbrussel.quize.implementation;

import be.intecbrussel.quize.QuizQuestion;

public class DivisionQuestion <T extends Number> implements QuizQuestion {

    private double firstNumber;
    private double secondNumber;

    public DivisionQuestion(T firstNumber, T secondNumber){
        this.firstNumber = Math.max(firstNumber.doubleValue(), secondNumber.doubleValue());
        this.secondNumber = Math.min(firstNumber.doubleValue(), secondNumber.doubleValue());
        this.secondNumber += this.secondNumber<0? 1:0;

    }


    @Override
    public String getQuestion() {
        return firstNumber + " : " + secondNumber;
    }

    @Override
    public double getCorrectAnswer() {
        return firstNumber / secondNumber;
    }
}
