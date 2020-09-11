package tech.dirickx.littlearithmetics.services.modelservice.impl;

import tech.dirickx.littlearithmetics.models.Answer;
import tech.dirickx.littlearithmetics.models.Question;
import tech.dirickx.littlearithmetics.models.Quiz;
import tech.dirickx.littlearithmetics.views.StringFormat;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class QuizReportService {

    private Quiz quiz;

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public double scorePercentage() {
        int totalQuestions = quiz.getQuestions().size();
        return (100 / (double) totalQuestions) * amountCorrectAnswers();
    }

    public int amountCorrectAnswers() {
        int correctAnswers = 0;
        correctAnswers = (int) quiz.getQuestions()
                .stream()
                .filter(question -> question.correctAnswer().setScale(2).equals(question.getAnswer().getAnswer().setScale(2)))
                .count();

        return correctAnswers;
    }

    public String totalDuration() {
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
        return StringFormat.durationToString(Duration.between(start, end));
    }


    public List<String> questionStringList() {
        return quiz.getQuestions()
                .stream()
                .map(Question::toString)
                .collect(Collectors.toList());
    }

    public List<String> durationStringList() {
        return quiz.getQuestions()
                .stream()
                .map(Question::getAnswer)
                .map(Answer::duration)
                .map(StringFormat::durationToString)
                .collect(Collectors.toList());
    }

    public List<Long> durationList() {
        return quiz.getQuestions()
                .stream()
                .map(Question::getAnswer)
                .map(Answer::duration)
                .map(duration -> duration.toSeconds())
                .collect(Collectors.toList());
    }

    public List<String> isCorrectList() {
        return quiz.getQuestions()
                .stream()
                .map(q -> q.getAnswer().getAnswer().setScale(2).equals(q.correctAnswer().setScale(2)))
                .map(b -> Boolean.toString(b))
                .collect(Collectors.toList());
    }

    public List<String> UserAnswers() {
        return quiz.getQuestions()
                .stream()
                .map(Question::getAnswer)
                .map(Answer::getAnswer)
                .map(StringFormat::bigDecimalToString)
                .collect(Collectors.toList());
    }

    public List<String> correctAnswer() {
        return quiz.getQuestions()
                .stream()
                .map(Question::correctAnswer)
                .map(StringFormat::bigDecimalToString)
                .collect(Collectors.toList());
    }

    public List<String> colorList() {
        return isCorrectList()
                .stream()
                .map(this::colorIFWrong)
                .collect(Collectors.toList());
    }

    public String colorIFWrong(String isTrue) {
        return isTrue.equals("true") ? "#90af2a" : "#CD5C5C";
    }

}
