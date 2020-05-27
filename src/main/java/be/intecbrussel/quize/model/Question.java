package be.intecbrussel.quize.model;

import javax.persistence.*;

@Entity
@Table(name = "questions")
@Inheritance
public abstract class Question implements QuestionInterface {


    @Id
    @GeneratedValue
    private long id;
    private double firstNumber;
    private double secondNumber;
    private String operator;
    @OneToOne
    private Answer answer;


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

