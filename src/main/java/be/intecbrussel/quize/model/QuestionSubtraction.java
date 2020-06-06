package be.intecbrussel.quize.model;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class QuestionSubtraction extends Question {

    private void switchNumbers() {
        BigDecimal max = super.operandFirst.max(super.operandSecond);
        super.operandSecond = super.operandFirst.min(super.operandSecond);
        super.operandFirst = max;
    }

    @Override
    public BigDecimal correctAnswer() {
        switchNumbers();
        return super.operandFirst.subtract(super.operandSecond);
    }

    @Override
    public String operatorString() {
        return "-";
    }


}
