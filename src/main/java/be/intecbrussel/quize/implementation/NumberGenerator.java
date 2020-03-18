package be.intecbrussel.quize.implementation;

import java.io.Serializable;
import java.util.*;

public class NumberGenerator<T extends Number> {
    private T firstNumber;
    private T secondNumber;
    private T upperBoundFirstNumber;
    private T lowerBoundFirstNumber;
    private T upperBoundSecondNumber;
    private T lowerBoundSecondNumber;
    private int amount = 100;
    private Random random = new Random();
    static private List<Number> firstNumbers = new ArrayList<Number>();
    static private List<Number> secondNumbers = new ArrayList<Number>();



    public NumberGenerator(T lowerBoundFirstNumber, T upperBoundFirstNumber) {
        this.upperBoundFirstNumber = upperBoundFirstNumber;
        this.lowerBoundFirstNumber = lowerBoundFirstNumber;
        this.upperBoundSecondNumber = upperBoundFirstNumber;
        this.lowerBoundSecondNumber = lowerBoundFirstNumber;
        this.amount = (int)upperBoundFirstNumber - (int)lowerBoundFirstNumber;
    }


    public NumberGenerator(T lowerBoundFirstNumber, T upperBoundFirstNumber, T lowerBoundSecondNumber, T upperBoundSecondNumber) {
        this.upperBoundFirstNumber = upperBoundFirstNumber;
        this.lowerBoundFirstNumber = lowerBoundFirstNumber;
        this.upperBoundSecondNumber = upperBoundSecondNumber;
        this.lowerBoundSecondNumber = lowerBoundSecondNumber;
        this.amount = (int)upperBoundFirstNumber - (int)lowerBoundFirstNumber;
    }


    public T getFirstNumber() {

        int size = Math.abs((int)upperBoundFirstNumber- (int)lowerBoundFirstNumber);

        if(firstNumbers.size() >= size){
            firstNumbers.clear();
        }


        boolean repeat = true;

        while (repeat) {

            if (upperBoundFirstNumber instanceof Double ||
                    lowerBoundFirstNumber instanceof Double ||
                    upperBoundSecondNumber instanceof Double ||
                    lowerBoundSecondNumber instanceof Double) {

                Double t = random.doubles(amount, (double) lowerBoundFirstNumber, (double) upperBoundFirstNumber).findAny().orElse(-1);
                t = Math.round(t * 100.0) / 100.0;
                firstNumber = (T) t;
            } else {
                Integer i = random.nextInt(this.upperBoundFirstNumber.intValue() - lowerBoundFirstNumber.intValue()) + lowerBoundFirstNumber.intValue();
                firstNumber = (T) i;
            }

            if(firstNumbers.indexOf(firstNumber) == -1){
                firstNumbers.add(firstNumber);
                repeat=false;
            }

        }

     return firstNumber;

    }



    public T getSecondNumber() {

        int size = Math.abs((int)upperBoundSecondNumber- (int)lowerBoundSecondNumber);

        if(secondNumbers.size() == size){
            secondNumbers.clear();
        }

        boolean repeat = true;

        while (repeat) {


            if (upperBoundSecondNumber instanceof Double ||
                    lowerBoundSecondNumber instanceof Double ||
                    upperBoundSecondNumber instanceof Double ||
                    lowerBoundSecondNumber instanceof Double) {


                Double t = random.doubles(amount, (double) lowerBoundSecondNumber, (double) upperBoundSecondNumber).findAny().orElse(-1);
                t = Math.round(t * 100.0) / 100.0;
                secondNumber = (T) t;
            } else {
                Integer i = random.nextInt(this.upperBoundSecondNumber.intValue() - lowerBoundSecondNumber.intValue()) + lowerBoundSecondNumber.intValue();
                secondNumber = (T) i;
            }

            if(secondNumbers.indexOf(secondNumber) == -1){
               secondNumbers.add(secondNumber);
                repeat=false;
            }


        }

        return secondNumber;
    }





}
