package be.intecbrussel.quize.model;

import be.intecbrussel.quize.QuizQuestion;

import javax.persistence.Entity;

@Entity
public class MultiplicationQuestion extends Question implements QuizQuestion {

    //___________________________________________________constructor
    public MultiplicationQuestion() {
    }

    //___________________________________________________methods
    @Override
    public double correctAnswer() {
        return super.firstNumber * super.secondNumber;
    }

    @Override
    public String getQuestion() {
        return QuizQuestion.question("x", super.firstNumber, super.secondNumber);
    }
}