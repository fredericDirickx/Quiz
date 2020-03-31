package be.intecbrussel.quize.implementation;

import be.intecbrussel.quize.QuizQuestion;

public class MultiplicationQuestion implements QuizQuestion {

    private double firstNumber;
    private double secondNumber;

    public MultiplicationQuestion(double firstNumber, double secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    @Override
    public double getCorrectAnswer() {
        return firstNumber * secondNumber;
    }

    @Override
    public String getQuestion() {
        return QuizQuestion.question("x", firstNumber, secondNumber);
    }
}
