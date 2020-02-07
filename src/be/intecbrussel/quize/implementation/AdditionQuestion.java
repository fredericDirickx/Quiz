package be.intecbrussel.quize.implementation;
import be.intecbrussel.quize.QuizQuestion;

public class AdditionQuestion<T extends Number> implements QuizQuestion {
    //___________________________________________________properties
    private T firstNumber;
    private T secondNumber;

    //___________________________________________________constructors
    public AdditionQuestion(T firstNumber, T secondNumber){
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    //___________________________________________________methods
    @Override
    public double getCorrectAnswer() {
        return  firstNumber.doubleValue() + secondNumber.doubleValue();
    }

    @Override
    public String getQuestion() {
        return firstNumber +" + "+ secondNumber + " = ?";
    }

}
