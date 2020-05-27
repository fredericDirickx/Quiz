package be.intecbrussel.quize.model;

public class Util {


    static String floatSwitch(double number) {
        if (number % 1 > 0) {
            return ".2";
        }
        return ".0";
    }

    static String question(String operator, double firstNumber, double secondNumber) {
        StringBuilder print = new StringBuilder();
        print.append(String.format("%" + Util.floatSwitch(firstNumber) + "f", firstNumber));
        print.append(" " + operator + " ");
        print.append(String.format("%" + Util.floatSwitch(secondNumber) + "f", secondNumber));
        print.append(" = ");
        return print.toString();
    }

}
