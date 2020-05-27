package be.intecbrussel.quize.model;

import javax.persistence.Entity;

@Entity
public class QuestionDivision extends Question {

    @Override
    public double correctAnswer() {
        switchNumbers();
        return super.firstNumber / super.secondNumber;
    }

    @Override
    public String operatorString() {
        return ":";
    }

    private void switchNumbers() {
        double max = Math.max(super.firstNumber, super.secondNumber);
        super.secondNumber = Math.min(super.firstNumber, super.secondNumber);
        super.firstNumber = max;
        if (super.secondNumber == 0.0) {
            super.secondNumber += 1;
        }
    }


}
