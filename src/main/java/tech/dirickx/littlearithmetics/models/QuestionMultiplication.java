package tech.dirickx.littlearithmetics.models;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Component
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



