package tech.dirickx.littlearithmetics.services.impl;

import tech.dirickx.littlearithmetics.models.Answer;
import tech.dirickx.littlearithmetics.models.Question;
import tech.dirickx.littlearithmetics.models.Quiz;
import tech.dirickx.littlearithmetics.views.StringFormat;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class QuizReportService {


    public double scorePercentage(Quiz quiz) {
        int totalQuestions = quiz.getQuestions().size();
        return (100 / (double) totalQuestions) * amountCorrectAnswers(quiz);
    }

    public int amountCorrectAnswers(Quiz quiz) {
        int correctAnswers = 0;
        correctAnswers = (int) quiz.getQuestions()
                .stream()
                .filter(s -> s.correctAnswer().equals(s.getAnswer().getAnswer()))
                .count();

        return correctAnswers;
    }

    public Duration totalDuration(Quiz quiz) {
        Temporal start = quiz.getQuestions()
                .stream()
                .map(Question::getAnswer)
                .map(Answer::getStartTime)
                .min(LocalDateTime::compareTo)
                .get();

        Temporal end = quiz.getQuestions()
                .stream()
                .map(Question::getAnswer)
                .map(Answer::getEndTime)
                .max(LocalDateTime::compareTo)
                .get();
        return Duration.between(start, end);
    }

    public List<String> questionStringList(Quiz quiz) {
        return quiz.getQuestions()
                .stream()
                .map(Question::toString)
                .collect(Collectors.toList());
    }

    public List<String> durationList(Quiz quiz) {
        return quiz.getQuestions()
                .stream()
                .map(Question::getAnswer)
                .map(Answer::duration)
                .map(StringFormat::durationToString)
                .collect(Collectors.toList());
    }

    public List<String> isCorrectList(Quiz quiz) {
        return quiz.getQuestions()
                .stream()
                .map(q -> q.getAnswer().getAnswer().equals(q.correctAnswer()))
                .map(b -> Boolean.toString(b))
                .collect(Collectors.toList());
    }

    public List<String> UserAnswers(Quiz quiz) {
        return quiz.getQuestions()
                .stream()
                .map(Question::getAnswer)
                .map(Answer::getAnswer)
                .map(BigDecimal::toString)
                .collect(Collectors.toList());
    }

    public List<String> correctAnswer(Quiz quiz) {
        return quiz.getQuestions()
                .stream()
                .map(Question::correctAnswer)
                .map(BigDecimal::toString)
                .collect(Collectors.toList());
    }

    public List<String> colorList(Quiz quiz) {
        return isCorrectList(quiz)
                .stream()
                .map(this::colorIFWrong)
                .collect(Collectors.toList());
    }

    public String colorIFWrong(String isTrue) {
        return isTrue.equals("true") ? "#90af2a" : "#CD5C5C";
    }

}
