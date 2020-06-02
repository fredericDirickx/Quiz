package be.intecbrussel.quize.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "questions")
@Inheritance
public abstract class Question {

    @Id
    @GeneratedValue
    protected long id;
    protected BigDecimal firstNumber;
    protected BigDecimal secondNumber;
    protected String operator;
    @OneToOne
    protected Answer answer;

    public Question(){
        this.operator = this.operatorString();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(BigDecimal firstNumber) {
        this.firstNumber = firstNumber;
    }

    public BigDecimal getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(BigDecimal secondNumber) {
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

    public abstract BigDecimal correctAnswer();

    public abstract String operatorString();

    @Override
    public String toString() {
        return firstNumber + " " + this.operatorString() + " " + secondNumber + " = ";
    }


}

