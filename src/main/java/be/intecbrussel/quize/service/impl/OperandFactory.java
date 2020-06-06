package be.intecbrussel.quize.service.impl;

import be.intecbrussel.quize.model.OperandBoundaries;
import be.intecbrussel.quize.model.QuizSettings;
import be.intecbrussel.quize.service.OperandService;

import java.math.BigDecimal;
import java.util.List;

public class OperandFactory {
    private List<BigDecimal[]> commutativeOperands;
    private List<BigDecimal[]> divisionOperands;
    private List<BigDecimal[]> subtractOperands;


    public OperandFactory(QuizSettings settings, OperandBoundaries boundaries){

        if(settings.isAddition() || settings.isMultiplication()) {
            OperandService operandService = new OperandServiceCommutativeImpl(boundaries);
            commutativeOperands = operandService.operandsList();
        }
        if(settings.isDivision()){
            OperandService operandService = new OperandServiceDivsionImpl(boundaries);
            divisionOperands = operandService.operandsList();
        }

        if(settings.isSubtraction()){
            OperandService operandService = new OperatorServiceSubtractImpl(boundaries);
            subtractOperands = operandService.operandsList();
        }
    }

    public List<BigDecimal[]> getCommutativeOperands() {
        return commutativeOperands;
    }

    public List<BigDecimal[]> getDivisionOperands() {
        return divisionOperands;
    }

    public List<BigDecimal[]> getSubtractOperands() {
        return subtractOperands;
    }
}
