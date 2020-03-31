package be.intecbrussel.quize.model;

import be.intecbrussel.quize.QuizQuestion;

public class AdditionQuestion implements QuizQuestion {
    //___________________________________________________properties
    private double firstNumber;
    private double secondNumber;

    //___________________________________________________constructors
    public AdditionQuestion(double firstNumber, double secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    //___________________________________________________methods
    @Override
    public double getCorrectAnswer() {
        return firstNumber + secondNumber;
    }

    @Override
    public String getQuestion() {
        return QuizQuestion.question("+", firstNumber, secondNumber);
    }

}
