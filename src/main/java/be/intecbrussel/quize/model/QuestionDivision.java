package be.intecbrussel.quize.model;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class QuestionDivision extends Question {

    @Override
    public BigDecimal correctAnswer() {

        return super.operandFirst.divide(super.operandSecond);
    }

    @Override
    public String operatorString() {
        return ":";
    }

}
