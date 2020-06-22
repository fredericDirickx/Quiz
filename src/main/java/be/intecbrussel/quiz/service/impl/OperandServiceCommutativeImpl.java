package be.intecbrussel.quiz.service.impl;

import be.intecbrussel.quiz.model.OperandBoundaries;
import be.intecbrussel.quiz.service.OperandService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OperandServiceCommutativeImpl implements OperandService {

    private OperandBoundaries boundaries;

    public OperandServiceCommutativeImpl(OperandBoundaries boundaries) {
        this.boundaries = boundaries;
    }

    @Override
    public List<BigDecimal[]> createOperandsList() {
        List<BigDecimal[]> operandsList = new ArrayList<>();
        List<BigDecimal> firstOperandList =
                SimpleOperandService.operandList(boundaries.getLowerBoundFirstNumber(), boundaries.getUpperBoundFirstNumber());
        List<BigDecimal> secondOperandList =
                SimpleOperandService.operandList(boundaries.getLowerBoundSecondNumber(), boundaries.getUpperBoundSecondNumber());

        for (BigDecimal firstNumber : firstOperandList) {
            for (BigDecimal secondNumber : secondOperandList) {
                BigDecimal[] operands = new BigDecimal[2];
                operands[0] = firstNumber;
                operands[1] = secondNumber;
                operandsList.add(operands);
            }
        }
        return operandsList;
    }


}
