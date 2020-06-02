package be.intecbrussel.quize.model;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class QuestionMultiplication extends Question {

    @Override
    public BigDecimal correctAnswer() {
        return super.firstNumber.multiply(super.secondNumber);
    }

    @Override
    public String operatorString() {
        return "*";
    }


}



