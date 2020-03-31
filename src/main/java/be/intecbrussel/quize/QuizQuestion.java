package be.intecbrussel.quize;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "operation", discriminatorType = DiscriminatorType.STRING)
public interface QuizQuestion {
    @Id
    long id = 0;

    static String floatSwitch(double number) {
        if (number % 1 > 0) {
            return ".2";
        }
        return ".0";
    }

    static String question(String operator, double firstNumber, double secondNumber) {
        StringBuilder print = new StringBuilder();
        print.append(String.format("%" + QuizQuestion.floatSwitch(firstNumber) + "f", firstNumber));
        print.append(" " + operator + " ");
        print.append(String.format("%" + QuizQuestion.floatSwitch(secondNumber) + "f", secondNumber));
        print.append(" = ?");
        return print.toString();
    }


    String getQuestion();

    double getCorrectAnswer();


}
