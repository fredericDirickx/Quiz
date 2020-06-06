package be.intecbrussel.quize.service.impl;

import be.intecbrussel.quize.model.OperandBoundaries;
import be.intecbrussel.quize.service.OperandService;

import java.math.BigDecimal;
import java.util.List;

public class OperandServiceDivsionImpl implements OperandService {

    private OperandBoundaries boundaries;

    public OperandServiceDivsionImpl(OperandBoundaries boundaries) {
        this.boundaries = boundaries;
    }

    @Override
    public List<BigDecimal[]> operandsList() {
        return null;
    }
}
