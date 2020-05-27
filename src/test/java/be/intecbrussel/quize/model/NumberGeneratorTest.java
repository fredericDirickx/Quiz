package be.intecbrussel.quize.model;

import be.intecbrussel.quize.service.NumberGeneratorService;

import java.util.Arrays;

class NumberGeneratorTest {

    NumberGeneratorService numberGenerator = new NumberGeneratorService(0, 11, 0, 11);

//    @Test
    public void TestGetIntegersForDivQuestion() {


        double[] numbers = numberGenerator.getIntegersForDivQuestion();

        for (int i = 1; i < 10; i++) {
            System.out.println(Arrays.toString(numberGenerator.getIntegersForDivQuestion()));
        }


    }

//    @Test
    void getRandomDivisor() {

        for (int i = 1; i < 10; i++) {
            System.out.println(numberGenerator.getRandomDivisor(100, 75));
        }


    }

}