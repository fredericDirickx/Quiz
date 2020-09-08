package tech.dirickx.littlearithmetics.models;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Component
public class OperandBoundaries {
    @Id
    @GeneratedValue
    private int id;
    private BigDecimal lowerBoundFirstNumber = BigDecimal.valueOf(2);
    private BigDecimal upperBoundFirstNumber = BigDecimal.valueOf(9);
    private BigDecimal lowerBoundSecondNumber = BigDecimal.valueOf(2);
    private BigDecimal upperBoundSecondNumber = BigDecimal.valueOf(9);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "OperandBoundaries{" +
                "id=" + id +
                ", lowerBoundFirstNumber=" + lowerBoundFirstNumber +
                ", upperBoundFirstNumber=" + upperBoundFirstNumber +
                ", lowerBoundSecondNumber=" + lowerBoundSecondNumber +
                ", upperBoundSecondNumber=" + upperBoundSecondNumber +
                '}';
    }
}
