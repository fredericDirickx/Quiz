package be.intecbrussel.quize.model;

import be.intecbrussel.quize.view.StringFormat;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.List;
import java.util.stream.Collectors;

public class QuizReport {
    private Quiz quiz;


    public QuizReport(Quiz quiz) {
        this.quiz = quiz;
    }

    public double scorePercentage() {
        int totalQuestions = quiz.getQuestions().size();
        return (100 / (double) totalQuestions) * (totalQuestions - wrongAnswers());
    }

    public int wrongAnswers() {
        int correctAnswers = 0;
        correctAnswers = (int) quiz.getQuestions()
                .stream()
                .filter(s -> s.correctAnswer() != s.getAnswer().getAnswer())
                .count();

        return correctAnswers;
    }

    private Duration setTotalDuration() {
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

    private List<String> setQuestionStringList() {
        return quiz.getQuestions()
                .stream()
                .map(Question::toString)
                .collect(Collectors.toList());
    }

    private List<String> setDurationList() {
        return quiz.getQuestions()
                .stream()
                .map(Question::getAnswer)
                .map(a -> Duration.between(a.getStartTime(), a.getEndTime()))
                .map(StringFormat::durationToString)
                .collect(Collectors.toList());


    }

    private List<String> isCorrectList() {
        return quiz.getQuestions()
                .stream()
                .map(q -> q.getAnswer().getAnswer() == q.correctAnswer())
                .map(b -> Boolean.toString(b))
                .collect(Collectors.toList());
    }

    private List<Answer> setUserAnswers() {
        return quiz.getQuestions()
                .stream()
                .map(Question::getAnswer)
                .collect(Collectors.toList());
    }

    private List<Double> setCorrectAnswer() {
        return quiz.getQuestions()
                .stream()
                .map(Question::correctAnswer)
                .collect(Collectors.toList());
    }

    public List<String> colorList(List<Question> questionList) {
        return isCorrectList()
                .stream()
                .map(this::colorIFWrong)
                .collect(Collectors.toList());
    }

    public String colorIFWrong(String isTrue) {
        return isTrue.equals("true") ? "#90af2a" : "#CD5C5C";
    }


}
