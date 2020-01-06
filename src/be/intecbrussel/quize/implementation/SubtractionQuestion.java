package be.intecbrussel.quize.implementation;
import be.intecbrussel.quize.QuizQuestion;

public class SubtractionQuestion implements QuizQuestion {
    //___________________________________________________properties
    private int firstNumber;
    private int secondNumber;

    //___________________________________________________constructors
    public SubtractionQuestion(int firstNumber, int secondNumber){
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    //___________________________________________________methods
    @Override
    public int getCorrectAnswer() {
        return Math.abs(firstNumber - secondNumber);
    }

    @Override
    public String getQuestion() {
        return firstNumber+ " - " + secondNumber + " = ?";
    }



}
