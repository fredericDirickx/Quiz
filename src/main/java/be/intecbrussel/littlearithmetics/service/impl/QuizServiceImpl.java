package be.intecbrussel.littlearithmetics.service.impl;

import be.intecbrussel.littlearithmetics.model.Answer;
import be.intecbrussel.littlearithmetics.model.Question;
import be.intecbrussel.littlearithmetics.model.Quiz;
import be.intecbrussel.littlearithmetics.service.QuizService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class QuizServiceImpl implements QuizService {

    public List<Question> createQuestions(Quiz quiz) {

        List<Question> questionList = new ArrayList<>();
        OperandsFactory operandsFactory =
                new OperandsFactory(quiz.getSettings(), quiz.getBoundaries());

        List<String> operators = quiz.getSettings().selectedOperators();
        for (int i = 0; i < quiz.getAmountQuestions(); i++) {
            Question question = QuestionFactory.createQuestion(operators);
            BigDecimal[] operands = operandsFactory.operandsForQuestion(question);
            question.setOperandFirst(operands[0]);
            question.setOperandSecond(operands[1]);
            question.setAnswer(new Answer());
            question.getAnswer().setAnswer(new BigDecimal("0"));
            questionList.add(question);
        }

        return questionList;
    }

}


