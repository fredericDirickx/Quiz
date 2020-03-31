package be.intecbrussel.quize.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberGenerator {

    static private List<Double> firstNumbers = new ArrayList<>();
    static private List<Double> secondNumbers = new ArrayList<>();
    private double upperBoundFirstNumber;
    private double lowerBoundFirstNumber;
    private double upperBoundSecondNumber;
    private double lowerBoundSecondNumber;
    private int amount = 100;
    private Random random = new Random();


    public NumberGenerator(double lowerBoundFirstNumber, double upperBoundFirstNumber) {
        this.upperBoundFirstNumber = upperBoundFirstNumber;
        this.lowerBoundFirstNumber = lowerBoundFirstNumber;
        this.upperBoundSecondNumber = upperBoundFirstNumber;
        this.lowerBoundSecondNumber = lowerBoundFirstNumber;
        this.amount = (int) (upperBoundFirstNumber - lowerBoundFirstNumber);
    }


    public NumberGenerator(double lowerBoundFirstNumber, double upperBoundFirstNumber, double lowerBoundSecondNumber, double upperBoundSecondNumber) {
        this.upperBoundFirstNumber = upperBoundFirstNumber;
        this.lowerBoundFirstNumber = lowerBoundFirstNumber;
        this.upperBoundSecondNumber = upperBoundSecondNumber;
        this.lowerBoundSecondNumber = lowerBoundSecondNumber;
        this.amount = (int) (upperBoundFirstNumber - lowerBoundFirstNumber);
    }

    public static double decimalPlacesController(double number, int amountOfDecimals) {

        int z = (int) (number * Math.pow(10, amountOfDecimals));
        number = (double) z / Math.pow(10, amountOfDecimals);

        return number;

    }

    public static int numberOfDecimals(double number) {
        double divisor = 1;
        double result = 1;
        boolean repeat = true;

        if (number % 1 == 0) {
            return 0;
        }

        while (repeat) {

            divisor *= 10;

            result = (number * divisor) % 1;

            repeat = !(result == 0);

        }

        return (int) Math.log10(divisor);
    }

    public double getRandomNumber(double upperBound, double lowerBound, int amount, List numbers, Random random) {

        double randomNumber = 0;

        int size = (int) Math.abs(upperBound - lowerBound);

        if (numbers.size() >= size) {
            numbers.clear();
        }

        boolean repeat = true;

        while (repeat) {

            randomNumber = random.doubles(amount, (double) lowerBound, (double) upperBound).findAny().orElse(-1);
            randomNumber = decimalPlacesController(randomNumber, 2);

            if (numbers.indexOf(randomNumber) == -1) {
                numbers.add(randomNumber);
                repeat = false;
            }

        }

        return randomNumber;

    }

    public double getFirstNumber() {
        return getRandomNumber(upperBoundFirstNumber, lowerBoundFirstNumber, amount, firstNumbers, random);
    }

    public double getSecondNumber() {
        return getRandomNumber(upperBoundSecondNumber, lowerBoundSecondNumber, amount, secondNumbers, random);
    }

    private int mostDecimals(double lower, double upper) {
        int x = numberOfDecimals(upper);
        int y = numberOfDecimals(lower);
        return Math.max(x, y);
    }


}
