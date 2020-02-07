package be.intecbrussel.quize.implementation;

import java.util.Random;
import java.util.function.DoubleBinaryOperator;

public class NumberGenerator<T extends Number> {
    private T firstNumber;
    private T secondNumber;
    private T upperBoundFirstNumber;
    private T lowerBoundFirstNumber;
    private T upperBoundSecondNumber;
    private T lowerBoundSecondNumber;
    final private int AMOUNT = 100;
    private Random random = new Random();


    public NumberGenerator(T lowerBoundFirstNumber, T upperBoundFirstNumber) {
        this.upperBoundFirstNumber = upperBoundFirstNumber;
        this.lowerBoundFirstNumber = lowerBoundFirstNumber;
        this.upperBoundSecondNumber = upperBoundFirstNumber;
        this.lowerBoundSecondNumber = lowerBoundFirstNumber;
    }


    public NumberGenerator(T lowerBoundFirstNumber, T upperBoundFirstNumber, T lowerBoundSecondNumber, T upperBoundSecondNumber) {
        this.upperBoundFirstNumber = upperBoundFirstNumber;
        this.lowerBoundFirstNumber = lowerBoundFirstNumber;
        this.upperBoundSecondNumber = upperBoundSecondNumber;
        this.lowerBoundSecondNumber = lowerBoundSecondNumber;
    }


    public T getFirstNumber() {
     if(upperBoundFirstNumber instanceof Double ||
        lowerBoundFirstNumber instanceof Double ||
        upperBoundSecondNumber instanceof Double ||
        lowerBoundSecondNumber instanceof Double){

         Double t = random.doubles(AMOUNT, (double) lowerBoundFirstNumber, (double) upperBoundFirstNumber).findAny().orElse(-1);
         t = Math.round(t*100.0)/100.0;
         firstNumber = (T) t;
     }else {
        Integer i = random.nextInt(this.upperBoundFirstNumber.intValue() - lowerBoundFirstNumber.intValue())+ lowerBoundFirstNumber.intValue();
        firstNumber = (T) i;
     }

     return firstNumber;
    }



    public T getSecondNumber() {
        if(upperBoundSecondNumber instanceof Double ||
           lowerBoundSecondNumber instanceof Double ||
           upperBoundSecondNumber instanceof Double ||
           lowerBoundSecondNumber instanceof Double){

            Double t = random.doubles(AMOUNT, (double) lowerBoundSecondNumber, (double) upperBoundSecondNumber).findAny().orElse(-1);
            t = Math.round(t*100.0)/100.0;
            secondNumber = (T) t;
        }else {
            Integer i = random.nextInt(this.upperBoundSecondNumber.intValue() - lowerBoundSecondNumber.intValue())+ lowerBoundSecondNumber.intValue();
            secondNumber = (T) i;
        }

        return secondNumber;
    }




}
