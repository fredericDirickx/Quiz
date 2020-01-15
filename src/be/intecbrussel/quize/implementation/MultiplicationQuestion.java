package be.intecbrussel.quize.implementation;

import be.intecbrussel.quize.QuizQuestion;

public class MultiplicationQuestion implements QuizQuestion {

    private int firstNumber;
    private int secondNumber;

    public MultiplicationQuestion(int firstNumber,int secondNumber){
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }


    @Override
    public String getQuestion() {
        return firstNumber + " x " + secondNumber;
    }

    @Override
    public int getCorrectAnswer() {
        return firstNumber * secondNumber;
    }
}
