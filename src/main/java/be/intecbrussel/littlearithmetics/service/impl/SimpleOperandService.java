package be.intecbrussel.littlearithmetics.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SimpleOperandService {

    public static List<BigDecimal> operandList(BigDecimal lower, BigDecimal upper) {
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
