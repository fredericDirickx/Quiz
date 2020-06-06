package be.intecbrussel.quize.service.services;

import be.intecbrussel.quize.model.Answer;
import be.intecbrussel.quize.model.Question;
import be.intecbrussel.quize.model.Quiz;
import be.intecbrussel.quize.service.OperandService;
import be.intecbrussel.quize.service.QuizService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizServiceImpl implements QuizService {


    public List<Question> createQuestions(Quiz quiz) {
        List<Question> questionList = new ArrayList<>();
        OperandService operandService = new OperandServiceImpl();
        List<BigDecimal[]> operandsList = operandService.operandsList(quiz.getBoundaries());

        if (quiz.getSettings().isShuffled()) {
            Collections.shuffle(operandsList);
        }

        List<String> operators = quiz.getSettings().selectedOperators();
        for (int i = 0; i< quiz.getAmountQuestions() ; i++) {
            Question question = QuestionFactory.createQuestion(operators);
            question.setOperandFirst(operandsList.get(i)[0]);
            question.setOperandSecond(operandsList.get(i)[1]);
            question.setAnswer(new Answer());
            question.getAnswer().setAnswer(new BigDecimal("0"));
            questionList.add(question);
        }

        return questionList;
    }


}


