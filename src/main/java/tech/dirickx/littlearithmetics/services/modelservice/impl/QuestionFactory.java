package tech.dirickx.littlearithmetics.services.modelservice.impl;

import org.springframework.stereotype.Component;
import tech.dirickx.littlearithmetics.models.*;

import java.util.List;
import java.util.Random;
@Component
public class QuestionFactory {

    public static Question createQuestion(String operator) {
        switch (operator) {
            case "*":
                return new QuestionMultiplication();
            case "-":
                return new QuestionSubtraction();
            case "/":
                return new QuestionDivision();
            default:
                return new QuestionAddition();
        }
    }

    public static Question createQuestion(List<String> operators) {
        Random random = new Random();
        int randomIndex = random.nextInt(operators.size());
        return createQuestion(operators.get(randomIndex));
    }

}
