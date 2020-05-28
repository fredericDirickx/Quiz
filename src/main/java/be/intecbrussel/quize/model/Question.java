package be.intecbrussel.quize.model;

import javax.persistence.*;
import java.time.Duration;

@Entity
@Table(name = "questions")
@Inheritance
public abstract class Question implements QuestionInterface {

    @Id
    @GeneratedValue
    protected long id;
    protected double firstNumber;
    protected double secondNumber;
    protected String operator;
    @OneToOne
    protected Answer answer;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }


    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }


    @Override
    public String toString() {
        return firstNumber + " " + operator + " " + secondNumber + " = ";
    }


}

