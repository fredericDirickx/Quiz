package be.intecbrussel.quize.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;

@Entity
public class Answer {
    @Id
    @GeneratedValue
    private int id;
    private double answer;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAnswer() {
        return answer;
    }

    public void setAnswer(double answer) {
        this.answer = answer;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Duration duration(){
        return Duration.between(this.startTime,this.endTime);
    }

}
