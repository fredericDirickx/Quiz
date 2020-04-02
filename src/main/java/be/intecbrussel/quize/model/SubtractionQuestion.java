package be.intecbrussel.quize.model;

import be.intecbrussel.quize.QuizQuestion;

import javax.persistence.Entity;

@Entity
public class SubtractionQuestion extends Question implements QuizQuestion {

    //___________________________________________________constructors
    public SubtractionQuestion() {
    }

    //___________________________________________________methods
    @Override
    public double correctAnswer() {
        super.firstNumber = Math.max(super.firstNumber, super.secondNumber);
        super.secondNumber = Math.min(super.firstNumber, super.secondNumber);
        return super.firstNumber - super.secondNumber;
    }

    @Override
    public String getQuestion() {
        super.firstNumber = Math.max(super.firstNumber, super.secondNumber);
        super.secondNumber = Math.min(super.firstNumber, super.secondNumber);
        return QuizQuestion.question("-", super.firstNumber, super.secondNumber);
    }


}
