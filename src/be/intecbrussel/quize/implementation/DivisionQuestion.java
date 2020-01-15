package be.intecbrussel.quize.implementation;

import be.intecbrussel.quize.QuizQuestion;

public class DivisionQuestion implements QuizQuestion {

    private int firstNumber;
    private int secondNumber;

    public DivisionQuestion(int firstNumber, int secondNumber){
        this.firstNumber = Math.max(firstNumber, secondNumber);
        this.secondNumber = Math.min(firstNumber, secondNumber);
    }


    @Override
    public String getQuestion() {
        return firstNumber + " : " + secondNumber;
    }

    @Override
    public int getCorrectAnswer() {
        return firstNumber / secondNumber;
    }
}
