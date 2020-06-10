package be.intecbrussel.quize.service.impl;

import be.intecbrussel.quize.model.OperandBoundaries;
import be.intecbrussel.quize.service.OperandService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static be.intecbrussel.quize.service.impl.SimpleOperandService.operandList;

public class OperandServiceDivisionImpl implements OperandService {

    private OperandBoundaries boundaries;

    public OperandServiceDivisionImpl(OperandBoundaries boundaries) {
        this.boundaries = boundaries;
    }

    @Override
    public List<BigDecimal[]> createOperandsList() {
        List<BigDecimal[]> operandsList = new ArrayList<>();
        List<BigDecimal> firstOperandList =
                operandList(boundaries.getLowerBoundFirstNumber(), boundaries.getUpperBoundFirstNumber());

        for (BigDecimal operandFirst : firstOperandList) {
            BigDecimal[] operandsArr = new BigDecimal[2];
            operandsArr[0] = operandFirst;
            operandsArr[1] = getRandomDivisor(operandFirst, boundaries.getLowerBoundSecondNumber());
            operandsList.add(operandsArr);
        }

        return operandsList;
    }

    public BigDecimal getRandomDivisor(BigDecimal dividend, BigDecimal lowerBound) {

        List<BigDecimal> dividerList = new ArrayList<>();
        Random random = new Random();
        BigDecimal divisor;
        int randomIndex;

        for (int i = lowerBound.intValue(); i <= dividend.intValue(); i++) {
            divisor = BigDecimal.valueOf(i);
            if (dividend.remainder(divisor).equals(BigDecimal.ZERO)) {
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
