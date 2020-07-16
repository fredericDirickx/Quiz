package tech.dirickx.littlearithmetics.models;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Component
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


