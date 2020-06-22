package be.intecbrussel.quize.service.impl;

import be.intecbrussel.quiz.model.OperandBoundaries;
import be.intecbrussel.quiz.service.impl.OperandServiceDivisionImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class OperandServiceDivisionImplTest {

    @Test
    void getRandomDivisor() {
        OperandBoundaries boundaries = new OperandBoundaries();
        OperandServiceDivisionImpl operandServiceDivision = new OperandServiceDivisionImpl(boundaries);
        BigDecimal result = operandServiceDivision.getRandomDivisor(BigDecimal.valueOf(10), BigDecimal.valueOf(2));

        Assertions.assertTrue(result.equals(BigDecimal.valueOf(1)) ||
                result.equals(BigDecimal.valueOf(2)) ||
                result.equals(BigDecimal.valueOf(10)) ||
                result.equals(BigDecimal.valueOf(5)) );

    }
}