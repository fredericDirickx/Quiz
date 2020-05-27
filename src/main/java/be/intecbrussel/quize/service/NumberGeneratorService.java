package be.intecbrussel.quize.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberGeneratorService {

    static private List<Double> firstNumbers = new ArrayList<>();
    static private List<Double> secondNumbers = new ArrayList<>();
    private double upperBoundFirstNumber;
    private double lowerBoundFirstNumber;
    private double upperBoundSecondNumber;
    private double lowerBoundSecondNumber;

    public NumberGeneratorService(double lowerBoundFirstNumber, double upperBoundFirstNumber) {
        this.upperBoundFirstNumber = upperBoundFirstNumber;
        this.lowerBoundFirstNumber = lowerBoundFirstNumber;
        this.upperBoundSecondNumber = upperBoundFirstNumber;
        this.lowerBoundSecondNumber = lowerBoundFirstNumber;
    }

    public NumberGeneratorService(double lowerBoundFirstNumber, double upperBoundFirstNumber, double lowerBoundSecondNumber, double upperBoundSecondNumber) {
        this.upperBoundFirstNumber = upperBoundFirstNumber;
        this.lowerBoundFirstNumber = lowerBoundFirstNumber;
        this.upperBoundSecondNumber = upperBoundSecondNumber;
        this.lowerBoundSecondNumber = lowerBoundSecondNumber;
    }

    public double getUpperBoundFirstNumber() {
        return upperBoundFirstNumber;
    }

    public void setUpperBoundFirstNumber(double upperBoundFirstNumber) {
        this.upperBoundFirstNumber = upperBoundFirstNumber;
    }

    public double getLowerBoundFirstNumber() {
        return lowerBoundFirstNumber;
    }

    public void setLowerBoundFirstNumber(double lowerBoundFirstNumber) {
        this.lowerBoundFirstNumber = lowerBoundFirstNumber;
    }

    public double getUpperBoundSecondNumber() {
        return upperBoundSecondNumber;
    }

    public void setUpperBoundSecondNumber(double upperBoundSecondNumber) {
        this.upperBoundSecondNumber = upperBoundSecondNumber;
    }

    public double getLowerBoundSecondNumber() {
        return lowerBoundSecondNumber;
    }

    public void setLowerBoundSecondNumber(double lowerBoundSecondNumber) {
        this.lowerBoundSecondNumber = lowerBoundSecondNumber;
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

    public double getRandomNumber(double upperBound, double lowerBound, List numbers) {

        double randomNumber = 0;
        int amount = (int) (upperBoundFirstNumber - lowerBoundFirstNumber);
        Random random = new Random();

        int size = (int) Math.abs(upperBound - lowerBound);

        if (numbers.size() >= size) {
            numbers.clear();
        }

        boolean repeat = true;

        while (repeat) {

            if (mostDecimals(lowerBound, upperBound) > 0) {
                randomNumber = random.doubles(amount, lowerBound, upperBound).findAny().orElse(-1);
                randomNumber = decimalPlacesController(randomNumber, 2);
            } else {
                randomNumber = random.nextInt((int) upperBound - (int) lowerBound) + (int) lowerBound;
            }


            if (numbers.indexOf(randomNumber) == -1) {
                numbers.add(randomNumber);
                repeat = false;
            }

        }

        return randomNumber;

    }

    public double getFirstNumber() {
        return getRandomNumber(upperBoundFirstNumber, lowerBoundFirstNumber, firstNumbers);
    }

    public double getSecondNumber() {
        return getRandomNumber(upperBoundSecondNumber, lowerBoundSecondNumber, secondNumbers);
    }

    private int mostDecimals(double lower, double upper) {
        int x = numberOfDecimals(upper);
        int y = numberOfDecimals(lower);
        return Math.max(x, y);
    }

    public int mostDecimals() {
        int x = numberOfDecimals(upperBoundFirstNumber);
        int y = numberOfDecimals(lowerBoundSecondNumber);
        return Math.max(x, y);
    }

    public double[] getIntegersForDivQuestion() {
        double[] numbers = new double[2];
        double firstNr = getFirstNumber();
        double secondNr = getRandomDivisor(firstNr, (int) lowerBoundSecondNumber);

        numbers[0] = firstNr;
        numbers[1] = secondNr;

        return numbers;

    }

    public double getRandomDivisor(double divided, int lowerBound) {
        Random random = new Random();
        List<Double> dividerList = new ArrayList<>();
        double divider = 0;
        int randomIndex;

        for (int i = lowerBound; i <= divided; i++) {
            divider = (double) i;
            if (divided % divider == 0) {
                dividerList.add(divider);
            }
        }

        if (dividerList.isEmpty()) {
            return divided;
        } else {
            randomIndex = random.nextInt(dividerList.size());
        }

        return dividerList.get(randomIndex);

    }

}
