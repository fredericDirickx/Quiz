package be.intecbrussel.quize.model;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class QuestionAddition extends Question {

    @Override
    public BigDecimal correctAnswer() {
        return super.firstNumber.add(this.secondNumber);
    }

    @Override
    public String operatorString() {
        return "+";
    }


}


