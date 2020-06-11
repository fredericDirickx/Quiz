package be.intecbrussel.quiz.service.impl;

import be.intecbrussel.quiz.model.OperandBoundaries;
import be.intecbrussel.quiz.model.Quiz;
import be.intecbrussel.quiz.model.QuizSettings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuizReportServiceTest {

    @Test
    void scorePercentage() {

        QuizServiceImpl quizService = new QuizServiceImpl();
        OperandBoundaries boundaries = new OperandBoundaries();
        QuizSettings settings = new QuizSettings();
        settings.setSubtraction(true);
        settings.setShuffled(true);
        Quiz quiz = new Quiz();

        quiz.setBoundaries(boundaries);
        quiz.setSettings(settings);
        quizService.createQuestions(quiz);
        quiz.setAmountQuestions(5);
        quiz.setQuestions(quizService.createQuestions(quiz));

        QuizReportService report = new QuizReportService();
//        System.out.println(report.scorePercentage(quiz));
//        quiz.getQuestions().forEach(System.out::println);

    }
}