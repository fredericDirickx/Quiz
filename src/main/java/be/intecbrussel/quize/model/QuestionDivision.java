package be.intecbrussel.quize.model;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class QuestionDivision extends Question {

    @Override
    public BigDecimal correctAnswer() {
        switchNumbers();
        return super.firstNumber.divide(super.secondNumber);
    }

    @Override
    public String operatorString() {
        return ":";
    }

    private void switchNumbers() {
        BigDecimal max = super.firstNumber.max(super.secondNumber) ;
        super.secondNumber = super.firstNumber.max(super.secondNumber);
        super.firstNumber = max;
        if (super.secondNumber.equals(BigDecimal.ZERO)) {
            super.secondNumber = BigDecimal.valueOf(1);
        }
    }


}
