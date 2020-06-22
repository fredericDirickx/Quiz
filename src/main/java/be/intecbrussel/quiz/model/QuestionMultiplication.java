package be.intecbrussel.quiz.model;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class QuestionMultiplication extends Question {

    @Override
    public BigDecimal correctAnswer() {
        return super.operandFirst.multiply(super.operandSecond);
    }

    @Override
    public String operatorString() {
        return "*";
    }

}



