package be.intecbrussel.littlearithmetics.service;

import be.intecbrussel.littlearithmetics.model.Question;
import be.intecbrussel.littlearithmetics.model.Quiz;

import java.util.List;

public interface QuizService {
    public List<Question> createQuestions(Quiz quiz);
}
