package be.intecbrussel.littlearithmetics.service.impl;

import be.intecbrussel.littlearithmetics.model.OperandBoundaries;
import be.intecbrussel.littlearithmetics.service.OperandService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OperandServiceSubtractImpl implements OperandService {

    private OperandBoundaries boundaries;

    public OperandServiceSubtractImpl(OperandBoundaries boundaries) {
        this.boundaries = boundaries;
    }

    @Override
    public List<BigDecimal[]> createOperandsList() {
        List<BigDecimal[]> operandsList = new ArrayList<>();
        List<BigDecimal> operandFirstList =
                SimpleOperandService.operandList(boundaries.getLowerBoundFirstNumber(),
                        boundaries.getUpperBoundFirstNumber());
        List<BigDecimal> operandSecondList =
                SimpleOperandService.operandList(boundaries.getLowerBoundSecondNumber(),
                        boundaries.getUpperBoundSecondNumber());

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
