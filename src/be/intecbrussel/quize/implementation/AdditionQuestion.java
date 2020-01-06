package be.intecbrussel.quize.implementation;
import be.intecbrussel.quize.QuizQuestion;

public class AdditionQuestion implements QuizQuestion {
    //___________________________________________________properties
    private int firstNumber;
    private int secondNumber;

    //___________________________________________________constructors
    public AdditionQuestion(int firstNumber, int secondNumber){
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    //___________________________________________________methods
    @Override
    public int getCorrectAnswer() {
        return firstNumber + secondNumber;
    }

    @Override
    public String getQuestion() {
        return firstNumber +" + "+ secondNumber + " = ?";
    }

}
