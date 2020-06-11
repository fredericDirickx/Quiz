package be.intecbrussel.quize.service.impl;

import be.intecbrussel.quiz.model.OperandBoundaries;
import be.intecbrussel.quiz.service.impl.OperatorServiceSubtractImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class OperatorServiceSubtractImplTest {

    @Test
    void operandsList() {
        OperandBoundaries boundaries = new OperandBoundaries();
        boundaries.setLowerBoundFirstNumber(BigDecimal.valueOf(1));
        boundaries.setUpperBoundFirstNumber(BigDecimal.valueOf(5));
        boundaries.setLowerBoundSecondNumber(BigDecimal.valueOf(2));
        boundaries.setUpperBoundSecondNumber(BigDecimal.valueOf(3));
        OperatorServiceSubtractImpl operatorServiceSubtract = new OperatorServiceSubtractImpl(boundaries);

        operatorServiceSubtract
                .createOperandsList()
                .forEach(s->Assertions.assertTrue(s[0].compareTo(s[1])>0));
    }
}