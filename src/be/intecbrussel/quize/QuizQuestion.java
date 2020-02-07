package be.intecbrussel.quize;

public interface QuizQuestion<T extends Number> {
    //___________________________________________________methods
    String getQuestion();
   double getCorrectAnswer();
}
