package be.intecbrussel.quize.model;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class QuestionDivision extends Question {

    @Override
    public BigDecimal correctAnswer() {
        switchNumbers();
        return super.operandFirst.divide(super.operandSecond);
    }

    @Override
    public String operatorString() {
        return ":";
    }

    private void switchNumbers() {
        BigDecimal max = super.operandFirst.max(super.operandSecond) ;
        super.operandSecond = super.operandFirst.max(super.operandSecond);
        super.operandFirst = max;
        if (super.operandSecond.equals(BigDecimal.ZERO)) {
            super.operandSecond = BigDecimal.valueOf(1);
        }
    }


}
