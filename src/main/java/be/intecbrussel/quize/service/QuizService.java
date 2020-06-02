package be.intecbrussel.quize.service;

import be.intecbrussel.quize.model.Question;
import be.intecbrussel.quize.model.Quiz;

import java.util.List;

public interface QuizService {
    public List<Question> createQuestions(Quiz quiz);
}
