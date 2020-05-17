package be.intecbrussel.quize.model;

import be.intecbrussel.quize.QuizQuestion;

import javax.persistence.Entity;

@Entity
public class AdditionQuestion extends Question implements QuizQuestion {


    public AdditionQuestion() {
    }

    //___________________________________________________methods

    @Override
    public void setOperator(String operator) {
        super.operator = "+";
    }

    @Override
    public double correctAnswer() {
        return super.firstNumber + super.secondNumber;
    }

    @Override
    public String getQuestion() {
        return QuizQuestion.question("+", super.firstNumber, super.secondNumber);
    }
}
