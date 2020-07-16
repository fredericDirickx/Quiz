package tech.dirickx.littlearithmetics.services;

import tech.dirickx.littlearithmetics.models.Question;
import tech.dirickx.littlearithmetics.models.Quiz;

import java.util.List;

public interface QuizService {
    public List<Question> createQuestions(Quiz quiz);
}
