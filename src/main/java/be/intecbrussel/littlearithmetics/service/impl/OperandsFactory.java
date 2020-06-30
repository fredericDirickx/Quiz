package be.intecbrussel.littlearithmetics.service.impl;

import be.intecbrussel.littlearithmetics.model.OperandBoundaries;
import be.intecbrussel.littlearithmetics.model.Question;
import be.intecbrussel.littlearithmetics.model.QuizSettings;
import be.intecbrussel.littlearithmetics.service.OperandService;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class OperandsFactory {

    private static int commutativeOperandsIndex;
    private static int divisionOperandsIndex;
    private static int subtractOperandsIndex;
    private List<BigDecimal[]> commutativeOperands;
    private List<BigDecimal[]> divisionOperands;
    private List<BigDecimal[]> subtractOperands;

    public OperandsFactory(QuizSettings settings, OperandBoundaries boundaries) {

        if (settings.isAddition() || settings.isMultiplication()) {
            OperandService operandService = new OperandServiceCommutativeImpl(boundaries);
            commutativeOperands = operandService.createOperandsList();
            if (settings.isShuffled()) {
                Collections.shuffle(commutativeOperands);
            }
        }
        if (settings.isDivision()) {
            OperandService operandService = new OperandServiceDivisionImpl(boundaries);
            divisionOperands = operandService.createOperandsList();
            if (settings.isShuffled()) {
                Collections.shuffle(divisionOperands);
            }
        }

        if (settings.isSubtraction()) {
            OperandService operandService = new OperandServiceSubtractImpl(boundaries);
            subtractOperands = operandService.createOperandsList();
            if (settings.isShuffled()) {
                Collections.shuffle(subtractOperands);
            }
        }
    }

    public BigDecimal[] operandsForQuestion(Question question) {
        BigDecimal[] operands = new BigDecimal[2];
        switch (question.getClass().getSimpleName()) {
            case "QuestionAddition":
            case "QuestionMultiplication":
                commutativeOperandsIndex =
                        commutativeOperandsIndex >= commutativeOperands.size() ? 0 : commutativeOperandsIndex;
                operands = commutativeOperands.get(commutativeOperandsIndex);
                commutativeOperandsIndex++;
                break;
            case "QuestionSubtraction":
                subtractOperandsIndex =
                        subtractOperandsIndex >= subtractOperands.size() ? 0 : subtractOperandsIndex;
                operands = subtractOperands.get(subtractOperandsIndex);
                subtractOperandsIndex++;
                break;
            case "QuestionDivision":
                divisionOperandsIndex =
                        divisionOperandsIndex >= divisionOperands.size() ? 0 : divisionOperandsIndex;
                operands = divisionOperands.get(divisionOperandsIndex);
                divisionOperandsIndex++;
                break;
        }

        return operands;
    }
}
