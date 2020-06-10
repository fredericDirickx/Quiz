package be.intecbrussel.quize.service.impl;

import be.intecbrussel.quize.model.OperandBoundaries;
import be.intecbrussel.quize.service.OperandService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static be.intecbrussel.quize.service.impl.SimpleOperandService.operandList;

public class OperatorServiceSubtractImpl implements OperandService {

    private OperandBoundaries boundaries;

    public OperatorServiceSubtractImpl(OperandBoundaries boundaries) {
        this.boundaries = boundaries;
    }

    @Override
    public List<BigDecimal[]> createOperandsList() {
        List<BigDecimal[]> operandsList = new ArrayList<>();
        List<BigDecimal> operandFirstList =
                operandList(boundaries.getLowerBoundFirstNumber(), boundaries.getUpperBoundFirstNumber());
        List<BigDecimal> operandSecondList =
                operandList(boundaries.getLowerBoundSecondNumber(), boundaries.getUpperBoundSecondNumber());

        for (BigDecimal operandFirst : operandFirstList) {
            for (BigDecimal operandSecond : operandSecondList) {
                if (operandFirst.subtract(operandSecond).compareTo(BigDecimal.ZERO) > 0) {
                    BigDecimal[] operandsArr = new BigDecimal[2];
                    operandsArr[0] = operandFirst;
                    operandsArr[1] = operandSecond;
                    if (!operandsList.contains(operandsArr)) {
                        operandsList.add(operandsArr);
                    }
                }
            }
        }
        return operandsList;
    }
}
