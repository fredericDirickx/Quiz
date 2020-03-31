package be.intecbrussel.quize.model;

import be.intecbrussel.quize.QuizQuestion;

public class DivisionQuestion implements QuizQuestion {

    private double firstNumber;
    private double secondNumber;

    public DivisionQuestion(double firstNumber, double secondNumber) {
        this.firstNumber = Math.max(firstNumber, secondNumber);
        this.secondNumber = Math.min(firstNumber, secondNumber);
        this.secondNumber += this.secondNumber < 0 ? 1 : 0;

    }

    @Override
    public double getCorrectAnswer() {
        return firstNumber / secondNumber;
    }

    @Override
    public String getQuestion() {
        return QuizQuestion.question(":", firstNumber, secondNumber);
    }
}
