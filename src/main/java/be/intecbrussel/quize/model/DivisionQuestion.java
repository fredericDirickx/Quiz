package be.intecbrussel.quize.model;

import be.intecbrussel.quize.QuizQuestion;

import javax.persistence.Entity;

@Entity
public class DivisionQuestion extends Question implements QuizQuestion {


    public DivisionQuestion() {

    }

    private void switchNumbers() {
        double max = Math.max(super.firstNumber, super.secondNumber);
        super.secondNumber = Math.min(super.firstNumber, super.secondNumber);
        super.firstNumber = max;
        if (super.secondNumber == 0.0) {
            super.secondNumber += 1;
        }
    }


    @Override
    public double correctAnswer() {
        switchNumbers();
        return super.firstNumber / super.secondNumber;
    }

    @Override
    public String getQuestion() {
        switchNumbers();
        return QuizQuestion.question(":", super.firstNumber, super.secondNumber);

    }


}
