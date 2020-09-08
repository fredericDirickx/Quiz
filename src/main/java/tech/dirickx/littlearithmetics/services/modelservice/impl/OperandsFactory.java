package tech.dirickx.littlearithmetics.services.modelservice.impl;

import tech.dirickx.littlearithmetics.models.OperandBoundaries;
import tech.dirickx.littlearithmetics.models.Question;
import tech.dirickx.littlearithmetics.models.QuizSettings;
import tech.dirickx.littlearithmetics.services.modelservice.OperandModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
@Component
public class OperandsFactory {

    private static int commutativeOperandsIndex;
    private static int divisionOperandsIndex;
    private static int subtractOperandsIndex;
    private List<BigDecimal[]> commutativeOperands;
    private List<BigDecimal[]> divisionOperands;
    private List<BigDecimal[]> subtractOperands;
    @Autowired
    public OperandsFactory(QuizSettings settings, OperandBoundaries boundaries) {

        if (settings.isAddition() || settings.isMultiplication()) {
            OperandModelService operandService = new OperandServiceCommutativeImpl(boundaries);
            commutativeOperands = operandService.createOperandsList();
            if (settings.isShuffled()) {
                Collections.shuffle(commutativeOperands);
            }
        }
        if (settings.isDivision()) {
            OperandModelService operandService = new OperandServiceDivisionImpl(boundaries);
            divisionOperands = operandService.createOperandsList();
            if (settings.isShuffled()) {
                Collections.shuffle(divisionOperands);
            }
        }

        if (settings.isSubtraction()) {
            OperandModelService operandService = new OperandServiceSubtractImpl(boundaries);
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
