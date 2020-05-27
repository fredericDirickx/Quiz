package be.intecbrussel.quize.model;

import javax.persistence.Entity;

@Entity
public class QuestionMultiplication extends Question {

    @Override
    public double correctAnswer() {
        return super.firstNumber * super.secondNumber;
    }

    @Override
    public String operatorString() {
        return "*";
    }


}



