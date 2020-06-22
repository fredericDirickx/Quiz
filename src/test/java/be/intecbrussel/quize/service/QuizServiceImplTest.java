package be.intecbrussel.quize.service;

import be.intecbrussel.quiz.dao.QuizDao;
import be.intecbrussel.quiz.dao.impl.QuizDaoImpl;
import be.intecbrussel.quiz.model.OperandBoundaries;
import be.intecbrussel.quiz.model.Quiz;
import be.intecbrussel.quiz.model.QuizSettings;
import be.intecbrussel.quiz.model.User;
import be.intecbrussel.quiz.service.QuizService;
import be.intecbrussel.quiz.service.impl.QuizServiceImpl;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class QuizServiceImplTest {

    @Test
    void createQuestions() {
        Quiz quiz = new Quiz();

        QuizSettings settings = new QuizSettings();
        settings.setDivision(true);
        settings.setShuffled(false);
//        settings.setSubtraction(true);

        settings.setShuffled(true);
        quiz.setSettings(settings);

        User user = new User();
        user.setName("Test");
        user.setPassword("123");
        quiz.setUser(user);

        OperandBoundaries boundaries = new OperandBoundaries();
        boundaries.setLowerBoundFirstNumber(BigDecimal.valueOf(2));
        boundaries.setUpperBoundFirstNumber(BigDecimal.valueOf(10));
        boundaries.setLowerBoundSecondNumber(BigDecimal.valueOf(2));
        boundaries.setUpperBoundSecondNumber(BigDecimal.valueOf(10));
        quiz.setBoundaries(boundaries);

        quiz.setAmountQuestions(10);

        QuizService quizService = new QuizServiceImpl();
        quiz.setQuestions(quizService.createQuestions(quiz));

        QuizDao<Quiz> quizDao = new QuizDaoImpl();
//        quizDao.create(quiz);


    }
}