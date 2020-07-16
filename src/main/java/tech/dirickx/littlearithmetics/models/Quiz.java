package tech.dirickx.littlearithmetics.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Component
public class Quiz {
    @Id
    @GeneratedValue
    private long id;
    @OneToOne
    private User user = new User();
    private LocalDate date = LocalDate.now();
    private int amountQuestions = 10;
    @OneToOne
    private OperandBoundaries boundaries;
    @OneToOne
    private QuizSettings settings;
    @OneToMany
    private List<Question> questions = new ArrayList<>();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getAmountQuestions() {
        return amountQuestions;
    }

    public void setAmountQuestions(int amountQuestions) {
        this.amountQuestions = amountQuestions;
    }

    public OperandBoundaries getBoundaries() {
        return boundaries;
    }

    public void setBoundaries(OperandBoundaries boundaries) {
        this.boundaries = boundaries;
    }

    public QuizSettings getSettings() {
        return settings;
    }

    public void setSettings(QuizSettings settings) {
        this.settings = settings;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
