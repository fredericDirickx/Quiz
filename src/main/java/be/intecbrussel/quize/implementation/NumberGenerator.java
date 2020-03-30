package be.intecbrussel.quize.implementation;

import java.io.Serializable;
import java.util.*;

public class NumberGenerator {
    private double firstNumber;
    private double secondNumber;
    private double upperBoundFirstNumber;
    private double lowerBoundFirstNumber;
    private double upperBoundSecondNumber;
    private double lowerBoundSecondNumber;
    private int amount = 100;
    private Random random = new Random();
    static private List<Double> firstNumbers = new ArrayList<>();
    static private List<Double> secondNumbers = new ArrayList<>();


    public NumberGenerator(double lowerBoundFirstNumber, double upperBoundFirstNumber) {
        this.upperBoundFirstNumber = upperBoundFirstNumber;
        this.lowerBoundFirstNumber = lowerBoundFirstNumber;
        this.upperBoundSecondNumber = upperBoundFirstNumber;
        this.lowerBoundSecondNumber = lowerBoundFirstNumber;
        this.amount = (int)(upperBoundFirstNumber - lowerBoundFirstNumber);
    }


    public NumberGenerator(double lowerBoundFirstNumber, double upperBoundFirstNumber, double lowerBoundSecondNumber, double upperBoundSecondNumber) {
        this.upperBoundFirstNumber = upperBoundFirstNumber;
        this.lowerBoundFirstNumber = lowerBoundFirstNumber;
        this.upperBoundSecondNumber = upperBoundSecondNumber;
        this.lowerBoundSecondNumber = lowerBoundSecondNumber;
        this.amount = (int)(upperBoundFirstNumber - lowerBoundFirstNumber);
    }


    public double getFirstNumber() {

        int size = (int) Math.abs(upperBoundFirstNumber - lowerBoundFirstNumber);

        if (firstNumbers.size() >= size) {
            firstNumbers.clear();
        }


        boolean repeat = true;

        while (repeat) {

            if (upperBoundFirstNumber instanceof double ||
                    lowerBoundFirstNumber instanceof double ||
                    upperBoundSecondNumber instanceof double ||
                    lowerBoundSecondNumber instanceof double) {

                Double t = random.doubles(amount, (double) lowerBoundFirstNumber, (double) upperBoundFirstNumber).findAny().orElse(-1);
                t = Math.round(t * 100.0) / 100.0;
                firstNumber = (T) t;
            } else {
                Integer i = random.nextInt(this.upperBoundFirstNumber.intValue() - lowerBoundFirstNumber.intValue()) + lowerBoundFirstNumber.intValue();
                firstNumber = (T) i;
            }

            if (firstNumbers.indexOf(firstNumber) == -1) {
                firstNumbers.add(firstNumber);
                repeat = false;
            }

        }


//        Double t = decimalPlacesController((double)firstNumber,mostDecimals(lowerBoundFirstNumber, upperBoundFirstNumber));
//        firstNumber = (T) t;

        return firstNumber;

    }


    public T getSecondNumber() {

        int size = Math.abs(upperBoundSecondNumber.intValue() - lowerBoundSecondNumber.intValue());

        if (secondNumbers.size() == size) {
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

            if (secondNumbers.indexOf(secondNumber) == -1) {
                secondNumbers.add(secondNumber);
                repeat = false;
            }


        }

//        Double t = decimalPlacesController((double)secondNumber,mostDecimals(lowerBoundSecondNumber, upperBoundSecondNumber));
//        secondNumber = (T) t;
        return secondNumber;
    }

    public static double decimalPlacesController(double number, int amountOfDecimals) {

        int z = (int) (number * Math.pow(10, amountOfDecimals));
        number = (double) z / Math.pow(10, amountOfDecimals);

        return number;

    }

//    public static int numberOfDecimals(double number) {
//        double divisor = 1;
//        double result = 1;
//        boolean repeat = true;
//
//        if (number % 1 == 0) {
//            return 0;
//        }
//
//
//        while (repeat) {
//
//            divisor *= 10;
//
//            result = (number * divisor) % 1;
//
//            repeat = !(result == 0);
//
//
//
//        }
//
//        return (int) Math.log10(divisor);
//    }
//
//    private int mostDecimals(T lower, T upper){
//        int x = numberOfDecimals(upper.doubleValue());
//        int y = numberOfDecimals(lower.doubleValue());
//
//        return Math.max(x, y);
//    }


}
