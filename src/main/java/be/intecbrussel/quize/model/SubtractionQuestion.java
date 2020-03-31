package be.intecbrussel.quize.model;

import be.intecbrussel.quize.QuizQuestion;

public class SubtractionQuestion implements QuizQuestion {
    //___________________________________________________properties
    private double firstNumber;
    private double secondNumber;

    //___________________________________________________constructors
    public SubtractionQuestion(double firstNumber, double secondNumber) {
        this.firstNumber = Math.max(firstNumber, secondNumber);
        this.secondNumber = Math.min(firstNumber, secondNumber);
    }

    //___________________________________________________methods
    @Override
    public double getCorrectAnswer() {
        return firstNumber - secondNumber;
    }

    @Override
    public String getQuestion() {
        return QuizQuestion.question("-", firstNumber, secondNumber);
    }


}
