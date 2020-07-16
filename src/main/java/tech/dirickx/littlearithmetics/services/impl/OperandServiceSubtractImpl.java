package tech.dirickx.littlearithmetics.services.impl;

import tech.dirickx.littlearithmetics.models.OperandBoundaries;
import tech.dirickx.littlearithmetics.services.OperandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Component
public class OperandServiceSubtractImpl implements OperandService {

    private OperandBoundaries boundaries;

    @Autowired
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
