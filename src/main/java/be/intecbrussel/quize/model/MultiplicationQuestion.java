package be.intecbrussel.quize.model;

import be.intecbrussel.quize.QuizQuestion;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("multiplication")
public class MultiplicationQuestion implements QuizQuestion {

    @Id @GeneratedValue
    long id;
    private double firstNumber;
    private double secondNumber;

    public MultiplicationQuestion(double firstNumber, double secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    @Override
    public double getCorrectAnswer() {
        return firstNumber * secondNumber;
    }

    @Override
    public String getQuestion() {
        return QuizQuestion.question("x", firstNumber, secondNumber);
    }
}
