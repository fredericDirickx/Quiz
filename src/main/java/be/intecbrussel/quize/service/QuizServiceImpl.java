package be.intecbrussel.quize.service;

import be.intecbrussel.quize.model.Answer;
import be.intecbrussel.quize.model.Question;
import be.intecbrussel.quize.model.Quiz;

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
            question.setFirstNumber(operandsList.get(i)[0]);
            question.setSecondNumber(operandsList.get(i)[1]);
            question.setAnswer(new Answer());
            question.getAnswer().setAnswer(new BigDecimal("0"));
            questionList.add(question);
        }

        return questionList;
    }


}


