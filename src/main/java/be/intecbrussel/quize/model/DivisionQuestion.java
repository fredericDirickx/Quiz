package be.intecbrussel.quize.model;

import be.intecbrussel.quize.QuizQuestion;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class DivisionQuestion extends Question implements QuizQuestion {


    public DivisionQuestion(){}


    @Override
    public double correctAnswer() {

        super.firstNumber = Math.max(super.firstNumber, super.secondNumber);
        super.secondNumber = Math.min(super.firstNumber, super.secondNumber);
        super.secondNumber += super.secondNumber == 0 ? 1 : 0;

        return super.firstNumber / super.secondNumber;
    }

    @Override
    public String getQuestion() {

        super.firstNumber = Math.max(super.firstNumber, super.secondNumber);
        super.secondNumber = Math.min(super.firstNumber, super.secondNumber);
        super.secondNumber += super.secondNumber == 0 ? 1 : 0;

        return QuizQuestion.question(":", super.firstNumber, super.secondNumber);

    }


}
