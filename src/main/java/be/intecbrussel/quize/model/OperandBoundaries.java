package be.intecbrussel.quize.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class OperandBoundaries {
    @Id
    @GeneratedValue
    private int id;
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
