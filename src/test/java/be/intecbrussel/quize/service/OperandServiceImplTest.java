package be.intecbrussel.quize.service;

import be.intecbrussel.quize.model.OperandBoundaries;
import be.intecbrussel.quize.service.impl.OperandServiceCommutativeImpl;

import java.math.BigDecimal;
import java.util.Arrays;

class OperandServiceImplTest {

    OperandServiceCommutativeImpl operandService = new OperandServiceCommutativeImpl();
    OperandBoundaries operandBoundaries = new OperandBoundaries();


//    @Test
    void operandsList() {
        operandBoundaries.setLowerBoundFirstNumber(BigDecimal.valueOf(1));
        operandBoundaries.setUpperBoundFirstNumber(BigDecimal.valueOf(2));
        operandBoundaries.setLowerBoundSecondNumber(BigDecimal.valueOf(1));
        operandBoundaries.setUpperBoundSecondNumber(BigDecimal.valueOf(2));
        operandService.operandsList(operandBoundaries).stream().map(Arrays::toString).forEach(System.out::println);
    }
}