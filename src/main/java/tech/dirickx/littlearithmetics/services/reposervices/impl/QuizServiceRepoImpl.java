package tech.dirickx.littlearithmetics.services.reposervices.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.dirickx.littlearithmetics.models.Quiz;
import tech.dirickx.littlearithmetics.repositories.QuizRepository;
import tech.dirickx.littlearithmetics.services.reposervices.QuizService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceRepoImpl implements QuizService {
    QuizRepository quizRepository;

    @Autowired
    public QuizServiceRepoImpl(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public List<Quiz> findListOfQuizByUserName(String userName) {
        List<Quiz> quizList = quizRepository.findAll();
        return quizList.stream()
                .filter(s->s.getUser().getUserName().equals(userName))
                .collect(Collectors.toList());
    }

    @Override
    public void save(Quiz quiz) {
        quizRepository.save(quiz);
    }

    @Override
    public Quiz findQuizById(Long id) {
       return quizRepository.findById(id).get();
    }

}
