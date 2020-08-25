package tech.dirickx.littlearithmetics.models;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
@Entity
@Component
public class QuizSettings {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    private boolean isAddition;
    private boolean isSubtraction;
    private boolean isMultiplication;
    private boolean isDivision;
    private boolean isShuffled;

    public boolean isAddition() {
        return isAddition;
    }

    public void setAddition(boolean addition) {
        isAddition = addition;
    }

    public boolean isSubtraction() {
        return isSubtraction;
    }

    public void setSubtraction(boolean subtraction) {
        isSubtraction = subtraction;
    }

    public boolean isMultiplication() {
        return isMultiplication;
    }

    public void setMultiplication(boolean multiplication) {
        isMultiplication = multiplication;
    }

    public boolean isDivision() {
        return isDivision;
    }

    public void setDivision(boolean division) {
        isDivision = division;
    }

    public boolean isShuffled() {
        return isShuffled;
    }

    public void setShuffled(boolean shuffled) {
        isShuffled = shuffled;
    }

    public List<String> selectedOperators(){
        List<String> operators = new ArrayList<>();
        if(isAddition){operators.add("+");}
        if(isDivision){operators.add("/");}
        if(isMultiplication){operators.add("*");}
        if(isSubtraction){operators.add("-");}
        return operators;
    }
}
