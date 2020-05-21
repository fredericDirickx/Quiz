package be.intecbrussel.quize.model;

import be.intecbrussel.quize.QuizQuestion;

import javax.persistence.*;

@Entity
@Table(name = "questions")
@Inheritance
public class Question implements QuizQuestion {

    @Transient
    String questionString;
    @Id
    @GeneratedValue
    protected long id;
    protected double firstNumber;
    protected double secondNumber;
    protected double answer;
    protected String operator;
    protected long duration;


    public Question() {
    }

    public static Question parseQuestionString(String questionString) {
        questionString = questionString.replaceAll("\\s", "");
        String[] numbers = questionString.split("[+\\-*=:?x]");
        String operator = questionString.replaceAll("[\\d.?=]", "");
        Question question = new Question();
        question.setFirstNumber(Double.parseDouble(numbers[0]));
        question.setSecondNumber(Double.parseDouble(numbers[1]));
        question.setOperator(operator);
        return question;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public double getAnswer() {
        return answer;
    }

    public void setAnswer(double answer) {
        this.answer = answer;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getQuestionString() {
        return getQuestion();
    }

    public void setQuestionString(String string) {
        this.questionString = string;
    }


    @Override
    public String getQuestion() {
        return "null";
    }

    @Override
    public double correctAnswer() {
        return 0;
    }

}

