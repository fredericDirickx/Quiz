package be.intecbrussel.quize.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class NumberGeneratorTest {

    NumberGenerator numberGenerator = new NumberGenerator(0, 11, 0, 11);

    @Test
    public void TestGetIntegersForDivQuestion() {


        double[] numbers = numberGenerator.getIntegersForDivQuestion();

        for (int i = 1; i < 10; i++) {
            System.out.println(Arrays.toString(numberGenerator.getIntegersForDivQuestion()));
        }


    }

    @Test
    void getRandomDivisor() {

        for (int i = 1; i < 10; i++) {
            System.out.println(numberGenerator.getRandomDivisor(100, 75));
        }


    }

}