package be.intecbrussel.quize.service;

import be.intecbrussel.quize.model.OperandBoundaries;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OperandServiceImpl implements OperandService {
    @Override
    public List<BigDecimal[]> operandsList(OperandBoundaries boundaries) {
        List<BigDecimal[]> operandsList = new ArrayList<>();
        List<BigDecimal> firstOperandList =
                operandList(boundaries.getLowerBoundFirstNumber(),boundaries.getUpperBoundFirstNumber());
        List<BigDecimal> secondOperandList =
                operandList(boundaries.getLowerBoundSecondNumber(), boundaries.getUpperBoundSecondNumber());



        for (BigDecimal firstNumber : firstOperandList) {
            for (BigDecimal secondNumber : secondOperandList) {
                BigDecimal[] operands = new BigDecimal[2];
                operands[0] = firstNumber;
                operands[1]=secondNumber;
                operandsList.add(operands);
            }
        }



        return operandsList;
    }

    public List<BigDecimal> operandList(BigDecimal lower, BigDecimal upper) {
        List<BigDecimal> operandList = new ArrayList();
        upper = upper.max(lower);
        lower = upper.min(lower);

        int scaleUpper = upper.scale();
        int scaleLower = lower.scale();
        int maxScale = Math.max(scaleUpper, scaleLower);

        upper = upper.movePointRight(maxScale);
        lower = lower.movePointRight(maxScale);

        for (int i = lower.intValue(); i <= upper.intValue(); i++) {
            BigDecimal operand = BigDecimal.valueOf(i).movePointLeft(maxScale);
            operandList.add(operand);
        }

        return operandList;
    }


}
