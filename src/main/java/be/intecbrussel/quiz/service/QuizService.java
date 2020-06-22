package be.intecbrussel.quiz.service;

import be.intecbrussel.quiz.model.Question;
import be.intecbrussel.quiz.model.Quiz;

import java.util.List;

public interface QuizService {
    public List<Question> createQuestions(Quiz quiz);
}
