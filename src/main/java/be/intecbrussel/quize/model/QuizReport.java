package be.intecbrussel.quize.model;

import be.intecbrussel.quize.view.StringFormat;

import java.time.Duration;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QuizReport {
    private double scorePercentage;
    private Duration totalDuration;
    private int wrongAnswers;
    private QuizService quizService;
    private List<String> questionList = new ArrayList<>();
    private List<String> durationList = new ArrayList<>();
    private List<String> isCorrectList = new ArrayList<>();
    private List<Double> userAnswers = new ArrayList<>();
    private List<Double> correctAnswers = new ArrayList<>();


    public QuizReport(QuizService quizService) {
        this.quizService = quizService;
        this.wrongAnswers = CorrectAnswers();
        setDurationList();
        setScorePercentage();
        setTotalDuration();
        setQuestionList();
        setCorrectAnswer();
        setUserAnswers();
        setIsCorrectList();
    }

    public double getScorePercentage() {
        return scorePercentage;
    }

    public void setScorePercentage(double scorePercentage) {
        this.scorePercentage = scorePercentage;
    }

    public Duration getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(Duration totalDuration) {
        this.totalDuration = totalDuration;
    }

    public int getWrongAnswers() {
        return wrongAnswers;
    }

    public void setWrongAnswers(int wrongAnswers) {
        this.wrongAnswers = wrongAnswers;
    }

    public QuizService getQuizService() {
        return quizService;
    }

    public void setQuizService(QuizService quizService) {
        this.quizService = quizService;
    }

    public List<String> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<String> questionList) {
        this.questionList = questionList;
    }

    public List<String> getDurationList() {
        return durationList;
    }

    public void setDurationList(List<String> durationList) {
        this.durationList = durationList;
    }

    public List<String> getIsCorrectList() {
        return isCorrectList;
    }

    public void setIsCorrectList(List<String> isCorrectList) {
        this.isCorrectList = isCorrectList;
    }

    public List<Double> getUserAnswers() {
        return userAnswers;
    }

    public void setUserAnswers(List<Double> userAnswers) {
        this.userAnswers = userAnswers;
    }

    public List<Double> getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(List<Double> correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public void setScorePercentage() {
        int totalQuestions = quizService.getAmountQuestions();
        scorePercentage = (100/(double) quizService.getAmountQuestions()) * (totalQuestions - wrongAnswers);
    }

    public int CorrectAnswers() {
        int correctAnswers = 0;
        correctAnswers = (int) quizService.getQuestions()
                .stream()
                .filter(s -> s.correctAnswer() != s.getAnswer())
                .count();

        return correctAnswers;
    }

    private void setTotalDuration() {
        int lastIndex = quizService.getEndTimes().size() - 1;
        Temporal start = quizService.getStartTimes().get(0);
        Temporal end = quizService.getEndTimes().get(lastIndex);
        totalDuration = Duration.between(start, end);
    }

    private void setQuestionList() {
        questionList = quizService.getQuestions()
                .stream()
                .map(Question::getQuestionString)
                .collect(Collectors.toList());
    }

    private void setDurationList() {
        durationList = quizService.getQuestions()
                .stream()
                .map(Question::getDuration)
                .map(Duration::ofSeconds)
                .map(StringFormat::durationToString)
                .collect(Collectors.toList());
    }

    private void setIsCorrectList() {
        isCorrectList = quizService.getQuestions()
                .stream()
                .map(q -> q.getAnswer() == q.correctAnswer())
                .map(b -> Boolean.toString(b))
                .collect(Collectors.toList());
    }

    private void setUserAnswers() {
        userAnswers = quizService.getQuestions()
                .stream()
                .map(Question::getAnswer)
                .collect(Collectors.toList());
    }

    private void setCorrectAnswer() {
        correctAnswers = quizService.getQuestions()
                .stream()
                .map(Question::correctAnswer)
                .collect(Collectors.toList());
    }

    public List<String> colorList(List<Question> questionList){
        return isCorrectList
                .stream()
                .map(this::colorIFWrong)
                .collect(Collectors.toList());
    }

    public String colorIFWrong(String isTrue){
       return isTrue.equals("true") ? "#90af2a" : "#CD5C5C";
    }


}
