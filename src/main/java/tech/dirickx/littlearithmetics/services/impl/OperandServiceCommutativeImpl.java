package tech.dirickx.littlearithmetics.services.impl;

import tech.dirickx.littlearithmetics.models.OperandBoundaries;
import tech.dirickx.littlearithmetics.services.OperandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Component
public class OperandServiceCommutativeImpl implements OperandService {

    private OperandBoundaries boundaries;

    @Autowired
    public OperandServiceCommutativeImpl(OperandBoundaries boundaries) {
        this.boundaries = boundaries;
    }

    @Override
    public List<BigDecimal[]> createOperandsList() {
        List<BigDecimal[]> operandsList = new ArrayList<>();
        List<BigDecimal> firstOperandList =
                SimpleOperandService.operandList(boundaries.getLowerBoundFirstNumber(),
                        boundaries.getUpperBoundFirstNumber());
        List<BigDecimal> secondOperandList =
                SimpleOperandService.operandList(boundaries.getLowerBoundSecondNumber(),
                        boundaries.getUpperBoundSecondNumber());

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
