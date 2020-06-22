package be.intecbrussel.quiz.model;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class QuestionAddition extends Question {

    @Override
    public BigDecimal correctAnswer() {
        return super.operandFirst.add(this.operandSecond);
    }

    @Override
    public String operatorString() {
        return "+";
    }

}


