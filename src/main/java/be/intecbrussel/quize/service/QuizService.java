//package be.intecbrussel.quize.service;
//
//import be.intecbrussel.quize.model.*;
//
//import java.util.*;
//
//import static java.time.LocalDateTime.now;
//
//public class QuizService {
//
//    public QuizService() {
//    }
//
//    //___________________________________________________methods
//
//    //will create the quiz: fill the questions list based on constructor parameters
//    public List<Question> createQuestions(QuestionSettings questionSettings, int amountQuestions) {
//        List<Question> questionList = new ArrayList<>();
//
//        Operations operations = new Operations(questionSettings);
//
//        int[] arr = operations.operations;
//
//        Random number = new Random();
//
//        int boundQuestions = 0;
//
//        boundQuestions += questionSettings.isAddition() ? 1 : 0;
//        boundQuestions += questionSettings.isSubtraction() ? 1 : 0;
//        boundQuestions += questionSettings.isMultiplication() ? 1 : 0;
//        boundQuestions += questionSettings.isDivision() ? 1 : 0;
//
//
//        for (int i = 0; i < amountQuestions; i++) {
//
//            int operation = arr[number.nextInt(boundQuestions)]; //get random number to switch randomly between addition
//            // and subtraction
//
//
//            if (operation == 0) {
//                QuestionAddition addQuestion = new QuestionAddition();
//                addQuestion.setFirstNumber(numberGenerator.getFirstNumber());
//                addQuestion.setSecondNumber(numberGenerator.getSecondNumber());
//                questionList.add(addQuestion);
//            } else if (operation == 1) {
//                QuestionSubtraction subQuestion = new QuestionSubtraction();
//                subQuestion.setFirstNumber(numberGenerator.getFirstNumber());
//                subQuestion.setSecondNumber(numberGenerator.getSecondNumber());
//                questionList.add(subQuestion);
//            } else if (operation == 2) {
//                QuestionMultiplication mulQuestion = new QuestionMultiplication();
//                mulQuestion.setFirstNumber(numberGenerator.getFirstNumber());
//                mulQuestion.setSecondNumber(numberGenerator.getSecondNumber());
//                questionList.add(mulQuestion);
//            } else if (operation == 3) {
//                QuestionDivision divQuestion = new QuestionDivision();
//                if (numberGenerator.mostDecimals() > 0) {
//                    divQuestion.setFirstNumber(numberGenerator.getFirstNumber());
//                    divQuestion.setSecondNumber(numberGenerator.getSecondNumber());
//                } else {
//                    double[] numbers = numberGenerator.getIntegersForDivQuestion();
//                    divQuestion.setFirstNumber(numbers[0]);
//                    divQuestion.setSecondNumber(numbers[1]);
//                }
//                questionList.add(divQuestion);
//            }
//
//        }
//
//        return questionList;
//    }
//
//
//    //inner class that will control the operations of the quiz based on constructor of QuizService
//    public class Operations {
//        //array of the different operations of the quiz
//        //Can be different options depending on what is set when QuizService is initialized
//        int[] operations = new int[0];
//
//        public Operations(QuestionSettings questionSettings) {
//
//            if (!questionSettings.isAddition() &&
//                    !questionSettings.isDivision() &&
//                    !questionSettings.isMultiplication() &&
//                    !questionSettings.isSubtraction()) {
//                questionSettings.setAddition(true);
//            }
//
//            if (questionSettings.isAddition()) {
//                addNumberToArr(0);
//            }
//            if (questionSettings.isSubtraction()) {
//                addNumberToArr(1);
//            }
//            if (questionSettings.isMultiplication()) {
//                addNumberToArr(2);
//            }
//            if (questionSettings.isDivision()) {
//                addNumberToArr(3);
//            }
//
//        }
//
//
//        private void addNumberToArr(int x) {
//            this.operations = Arrays.copyOf(this.operations, this.operations.length + 1);
//            this.operations[this.operations.length - 1] = x;
//        }
//
//    }
//
//
//}
//
//
