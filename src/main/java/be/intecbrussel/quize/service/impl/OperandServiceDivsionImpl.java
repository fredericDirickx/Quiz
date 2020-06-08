package be.intecbrussel.quize.service.impl;

import be.intecbrussel.quize.model.OperandBoundaries;
import be.intecbrussel.quize.service.OperandService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static be.intecbrussel.quize.service.impl.SimpleOperandFactory.operandList;

public class OperandServiceDivsionImpl implements OperandService {

    private OperandBoundaries boundaries;

    public OperandServiceDivsionImpl(OperandBoundaries boundaries) {
        this.boundaries = boundaries;
    }

    @Override
    public List<BigDecimal[]> operandsList() {
        List<BigDecimal[]> operandsList = new ArrayList<>();
        List<BigDecimal> firstOperandList =
                operandList(boundaries.getLowerBoundFirstNumber(),boundaries.getUpperBoundSecondNumber());

        return null;
    }




    public BigDecimal[] getIntegersForDivQuestion(BigDecimal operandFirst, BigDecimal lowerBoundOperandSecond) {
        BigDecimal[] numbers = new BigDecimal[2];
        BigDecimal firstOp = operandFirst;
        BigDecimal secondOp = getRandomDivisor(firstOp, lowerBoundOperandSecond);

        numbers[0] = firstOp;
        numbers[1] = secondOp;

        return numbers;

    }

    public BigDecimal getRandomDivisor(BigDecimal dividend, BigDecimal lowerBound) {

        List<BigDecimal> dividerList = new ArrayList<>();
        Random random = new Random();
        BigDecimal divisor;
        int randomIndex;

        for (int i = lowerBound.intValue(); i <= dividend.intValue(); i++) {
            divisor = BigDecimal.valueOf(i);
            if (dividend.divide(divisor).equals(BigDecimal.ZERO)) {
                dividerList.add(divisor);
            }
        }

        if (dividerList.isEmpty()) {
            return dividend;
        } else {
            randomIndex = random.nextInt(dividerList.size());
        }

        return dividerList.get(randomIndex);
    }

}
