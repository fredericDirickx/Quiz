package be.intecbrussel.quize.service.impl;

import be.intecbrussel.quize.model.OperandBoundaries;
import be.intecbrussel.quize.service.OperandService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static be.intecbrussel.quize.service.impl.SimpleOperandService.operandList;

public class OperandServiceCommutativeImpl implements OperandService {

    private OperandBoundaries boundaries;

    public OperandServiceCommutativeImpl(OperandBoundaries boundaries) {
        this.boundaries = boundaries;
    }

    @Override
    public List<BigDecimal[]> createOperandsList() {
        List<BigDecimal[]> operandsList = new ArrayList<>();
        List<BigDecimal> firstOperandList =
                operandList(boundaries.getLowerBoundFirstNumber(), boundaries.getUpperBoundFirstNumber());
        List<BigDecimal> secondOperandList =
                operandList(boundaries.getLowerBoundSecondNumber(), boundaries.getUpperBoundSecondNumber());

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
