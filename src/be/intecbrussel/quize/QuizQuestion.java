package be.intecbrussel.quize;

import java.io.Serializable;

public interface QuizQuestion<T extends Number> extends Serializable {
    //___________________________________________________methods
    String getQuestion();
   double getCorrectAnswer();

    static String floatSwitch(double number){
        if(number%1>0){
            return ".2";
        }
        return ".0";
    }

    static String question(String operator, double firstNumber, double secondNumber){
        StringBuilder print = new StringBuilder();
        print.append(String.format("%"+QuizQuestion.floatSwitch(firstNumber)+"f",firstNumber));
        print.append(" "+operator+" ");
        print.append(String.format("%"+QuizQuestion.floatSwitch(secondNumber)+"f",secondNumber));
        print.append(" = ?");
        return print.toString();
    }


}
