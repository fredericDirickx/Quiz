package be.intecbrussel.quize.model;

import be.intecbrussel.quize.QuizQuestion;

import javax.persistence.*;

@Entity
@Table(name = "questions")
@Inheritance
public class Question implements QuizQuestion  {

    @Id
    @GeneratedValue
    long id;
    double firstNumber;
    double secondNumber;
    double answer;
    long duration;


    public Question() {
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

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
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
