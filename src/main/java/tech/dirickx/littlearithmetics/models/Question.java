package tech.dirickx.littlearithmetics.models;

import org.springframework.stereotype.Component;
import tech.dirickx.littlearithmetics.views.StringFormat;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "questions")
@Inheritance
@Component
public abstract class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;
    protected BigDecimal operandFirst;
    protected BigDecimal operandSecond;
    protected String operator;
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    protected Answer answer;

    public Question() {
        this.operator = this.operatorString();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getOperandFirst() {
        return operandFirst;
    }

    public void setOperandFirst(BigDecimal firstNumber) {
        this.operandFirst = firstNumber;
    }

    public BigDecimal getOperandSecond() {
        return operandSecond;
    }

    public void setOperandSecond(BigDecimal secondNumber) {
        this.operandSecond = secondNumber;
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
        return StringFormat.bigDecimalToString(operandFirst) + " " +
                this.operatorString() + " " +
                StringFormat.bigDecimalToString(operandSecond) + " = ";
    }

}

