package be.intecbrussel.quize.service;

import be.intecbrussel.quize.model.OperandBoundaries;

import java.math.BigDecimal;
import java.util.List;

public interface OperandService {
    List<BigDecimal[]> operandsList(OperandBoundaries settings);
}
