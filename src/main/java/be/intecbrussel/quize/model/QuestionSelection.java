package be.intecbrussel.quize.model;

import be.intecbrussel.quize.service.QuizService;

import java.util.Random;

public class QuestionSelection {
    private boolean IsAddition = true;
    private boolean IsSubtraction;
    private boolean IsMultiplication;
    private boolean IsDivision;

    public boolean isAddition() {
        return IsAddition;
    }

    public void setAddition(boolean addition) {
        IsAddition = addition;
    }

    public boolean isSubtraction() {
        return IsSubtraction;
    }

    public void setSubtraction(boolean subtraction) {
        IsSubtraction = subtraction;
    }

    public boolean isMultiplication() {
        return IsMultiplication;
    }

    public void setMultiplication(boolean multiplication) {
        IsMultiplication = multiplication;
    }

    public boolean isDivision() {
        return IsDivision;
    }

    public void setDivision(boolean division) {
        IsDivision = division;
    }

}
