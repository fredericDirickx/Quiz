package be.intecbrussel.quize.model;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class QuestionSubtraction extends Question {

    private void switchNumbers() {
        BigDecimal max = super.firstNumber.max(super.secondNumber);
        super.secondNumber = super.firstNumber.min(super.secondNumber);
        super.firstNumber = max;
    }

    @Override
    public BigDecimal correctAnswer() {
        switchNumbers();
        return super.firstNumber.subtract(super.secondNumber);
    }

    @Override
    public String operatorString() {
        return "-";
    }


}
