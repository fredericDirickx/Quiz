package be.intecbrussel.quize.service.impl;

import be.intecbrussel.quize.model.OperandBoundaries;
import be.intecbrussel.quize.service.OperandService;

import java.math.BigDecimal;
import java.util.List;

public class OperatorServiceSubtractImpl implements OperandService {

    private OperandBoundaries boundaries;

    public OperatorServiceSubtractImpl(OperandBoundaries boundaries) {
        this.boundaries = boundaries;
    }

    @Override
    public List<BigDecimal[]> operandsList() {
        return null;
    }
}
