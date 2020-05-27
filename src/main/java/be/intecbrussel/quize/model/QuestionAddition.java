package be.intecbrussel.quize.model;

import javax.persistence.Entity;

@Entity
public class QuestionAddition extends Question  {

    @Override
    public double correctAnswer() {
        return super.firstNumber + super.secondNumber;
    }

    @Override
    public String operatorString() {
        return "+";
    }

}


