package be.intecbrussel.quize.service;

import be.intecbrussel.quize.model.OperandBoundaries;
import be.intecbrussel.quize.service.impl.OperandServiceCommutativeImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class OperandServiceImplTest {





    @Test
    void operandsList() {
        OperandBoundaries operandBoundaries = new OperandBoundaries();
        OperandServiceCommutativeImpl operandService = new OperandServiceCommutativeImpl(operandBoundaries);
        operandBoundaries.setLowerBoundFirstNumber(BigDecimal.valueOf(1));
        operandBoundaries.setUpperBoundFirstNumber(BigDecimal.valueOf(2));
        operandBoundaries.setLowerBoundSecondNumber(BigDecimal.valueOf(1));
        operandBoundaries.setUpperBoundSecondNumber(BigDecimal.valueOf(2));
        operandService
                .createOperandsList()
                .forEach(Assertions::assertNotNull);
    }
}