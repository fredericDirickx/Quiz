package be.intecbrussel.quize.model;

import be.intecbrussel.quize.QuizQuestion;

import javax.persistence.Entity;

@Entity
public class SubtractionQuestion extends Question implements QuizQuestion {

    //___________________________________________________constructors
    public SubtractionQuestion() {
        super.operator = "-";
    }

    //___________________________________________________methods
    @Override
    public String getOperator() {
        return super.operator;
    }

    private void switchNumbers() {
        double max = Math.max(super.firstNumber, super.secondNumber);
        super.secondNumber = Math.min(super.firstNumber, super.secondNumber);
        super.firstNumber = max;
    }


    @Override
    public double correctAnswer() {
        switchNumbers();
        return super.firstNumber - super.secondNumber;
    }

    @Override
    public String getQuestion() {
        switchNumbers();
        return QuizQuestion.question("-", super.firstNumber, super.secondNumber);
    }



}
