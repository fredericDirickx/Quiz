package tech.dirickx.littlearithmetics.services.reposervices;

import tech.dirickx.littlearithmetics.models.Quiz;
import tech.dirickx.littlearithmetics.models.User;

import java.util.List;

public interface QuizService {
    List<Quiz> findListOfQuizByUserName(String userName);
    Quiz findQuizById(Long id);
    void save(Quiz quiz);
}
