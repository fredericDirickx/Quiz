package be.intecbrussel.quize.model;

import java.math.BigDecimal;

public class OperandBoundaries {
    private BigDecimal lowerBoundFirstNumber = BigDecimal.valueOf(1);
    private BigDecimal upperBoundFirstNumber = BigDecimal.valueOf(10);
    private BigDecimal lowerBoundSecondNumber = BigDecimal.valueOf(1);
    private BigDecimal upperBoundSecondNumber = BigDecimal.valueOf(10);

    public BigDecimal getLowerBoundFirstNumber() {
        return lowerBoundFirstNumber;
    }

    public void setLowerBoundFirstNumber(BigDecimal lowerBoundFirstNumber) {
        this.lowerBoundFirstNumber = lowerBoundFirstNumber;
    }

    public BigDecimal getUpperBoundFirstNumber() {
        return upperBoundFirstNumber;
    }

    public void setUpperBoundFirstNumber(BigDecimal upperBoundFirstNumber) {
        this.upperBoundFirstNumber = upperBoundFirstNumber;
    }

    public BigDecimal getLowerBoundSecondNumber() {
        return lowerBoundSecondNumber;
    }

    public void setLowerBoundSecondNumber(BigDecimal lowerBoundSecondNumber) {
        this.lowerBoundSecondNumber = lowerBoundSecondNumber;
    }

    public BigDecimal getUpperBoundSecondNumber() {
        return upperBoundSecondNumber;
    }

    public void setUpperBoundSecondNumber(BigDecimal upperBoundSecondNumber) {
        this.upperBoundSecondNumber = upperBoundSecondNumber;
    }
}
