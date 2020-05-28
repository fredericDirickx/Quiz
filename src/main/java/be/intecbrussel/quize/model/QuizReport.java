package be.intecbrussel.quize.model;

import be.intecbrussel.quize.view.StringFormat;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.List;
import java.util.stream.Collectors;

public class QuizReport {

    public double scorePercentage(Quiz quiz) {
        int totalQuestions = quiz.getQuestions().size();
        return (100 / (double) totalQuestions) * (totalQuestions - wrongAnswers(quiz));
    }

    public int wrongAnswers(Quiz quiz) {
        int correctAnswers = 0;
        correctAnswers = (int) quiz.getQuestions()
                .stream()
                .filter(s -> s.correctAnswer() != s.getAnswer().getAnswer())
                .count();

        return correctAnswers;
    }

    private Duration TotalDuration(Quiz quiz) {
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

    private List<String> QuestionStringList(Quiz quiz) {
        return quiz.getQuestions()
                .stream()
                .map(Question::toString)
                .collect(Collectors.toList());
    }

    private List<String> DurationList(Quiz quiz) {
        return quiz.getQuestions()
                .stream()
                .map(Question::getAnswer)
                .map(Answer::duration)
                .map(StringFormat::durationToString)
                .collect(Collectors.toList());
    }

    private List<String> isCorrectList(Quiz quiz) {
        return quiz.getQuestions()
                .stream()
                .map(q -> q.getAnswer().getAnswer() == q.correctAnswer())
                .map(b -> Boolean.toString(b))
                .collect(Collectors.toList());
    }

    private List<Answer> UserAnswers(Quiz quiz) {
        return quiz.getQuestions()
                .stream()
                .map(Question::getAnswer)
                .collect(Collectors.toList());
    }

    private List<Double> CorrectAnswer(Quiz quiz) {
        return quiz.getQuestions()
                .stream()
                .map(Question::correctAnswer)
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
