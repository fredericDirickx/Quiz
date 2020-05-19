package be.intecbrussel.quize.model;

import be.intecbrussel.quize.QuizQuestion;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.util.*;

import static be.intecbrussel.quize.view.ConsoleColors.*;
import static java.time.LocalDateTime.now;

@Entity
public class QuizService {
    //___________________________________________________properties

    @Id
    @GeneratedValue
    private long id;
    @OneToOne
    private User user = new User();
    private LocalDate date = LocalDate.now();
    private boolean IsAddition;
    private boolean IsSubtraction;
    private boolean IsMultiplication;
    private boolean IsDivision;
    private int amountQuestions = 10;

    private int totalGoodQuestions;
    private int totalQuestions;
    private double totalPercent;
    private Duration totalTime = Duration.ofSeconds(0);

    @Transient
    private ArrayList<Double> userAnswers = new ArrayList<>();
    @Transient
    private ArrayList<Temporal> startTimes = new ArrayList<>();
    @Transient
    private ArrayList<Temporal> endTimes = new ArrayList<>();
    @OneToMany
    private List<Question> questions = new ArrayList<>();

    @Transient
    private int lastQuestionNr;
    @Transient
    private NumberGenerator numberGenerator = new NumberGenerator(1,10,1,10);

    //___________________________________________________constructors
    public QuizService() {
    }

    //___________________________________________________getters & setters

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

    public boolean isIsAddition() {
        return IsAddition;
    }

    public void setIsAddition(boolean addition) {
        this.IsAddition = addition;
    }

    public boolean isIsSubtraction() {
        return IsSubtraction;
    }

    public void setIsSubtraction(boolean subtraction) {
        this.IsSubtraction = subtraction;
    }

    public boolean isIsMultiplication() {
        return IsMultiplication;
    }

    public void setIsMultiplication(boolean multiplication) {
        this.IsMultiplication = multiplication;
    }

    public boolean isIsDivision() {
        return IsDivision;
    }

    public void setIsDivision(boolean division) {
        this.IsDivision = division;
    }

    public int getAmountQuestions() {
        return amountQuestions;
    }

    public void setAmountQuestions(int amountQuestions) {
        this.amountQuestions = amountQuestions;
    }

    public int getTotalGoodQuestions() {
        return totalGoodQuestions;
    }

    public void setTotalGoodQuestions(int totalGoodQuestions) {
        this.totalGoodQuestions = totalGoodQuestions;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public double getTotalPercent() {
        return totalPercent;
    }

    public void setTotalPercent(double totalPercent) {
        this.totalPercent = totalPercent;
    }

    public Duration getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Duration totalTime) {
        this.totalTime = totalTime;
    }

    public ArrayList<Double> getUserAnswers() {
        return userAnswers;
    }

    public void setUserAnswers(ArrayList<Double> userAnswers) {
        this.userAnswers = userAnswers;
    }

    public ArrayList<Temporal> getStartTimes() {
        return startTimes;
    }

    public void setStartTimes(ArrayList<Temporal> startTimes) {
        this.startTimes = startTimes;
    }

    public ArrayList<Temporal> getEndTimes() {
        return endTimes;
    }

    public void setEndTimes(ArrayList<Temporal> endTimes) {
        this.endTimes = endTimes;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }


    public int getLastQuestionNr() {
        return lastQuestionNr;
    }

    public void setLastQuestionNr(int lastQuestionNr) {
        this.lastQuestionNr = lastQuestionNr;
    }

    public NumberGenerator getNumberGenerator() {
        return numberGenerator;
    }

    public void setNumberGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }


    //___________________________________________________methods

    //will create the quiz: fill the questions list based on constructor parameters
    public void createQuiz() {

        Operations operations = new Operations();

        int[] arr = operations.operations;

        Random number = new Random();

        int boundQuestions = 0;

        boundQuestions += this.IsAddition ? 1 : 0;
        boundQuestions += this.IsSubtraction ? 1 : 0;
        boundQuestions += this.IsMultiplication ? 1 : 0;
        boundQuestions += this.IsDivision ? 1 : 0;


        for (int i = 0; i < amountQuestions; i++) {

            int operation = arr[number.nextInt(boundQuestions)]; //get random number to switch randomly between addition
            // and subtraction


            if (operation == 0) {
                AdditionQuestion addQuestion = new AdditionQuestion();
                addQuestion.setFirstNumber(numberGenerator.getFirstNumber());
                addQuestion.setSecondNumber(numberGenerator.getSecondNumber());
                questions.add(addQuestion);
            } else if (operation == 1) {
                SubtractionQuestion subQuestion = new SubtractionQuestion();
                subQuestion.setFirstNumber(numberGenerator.getFirstNumber());
                subQuestion.setSecondNumber(numberGenerator.getSecondNumber());
                questions.add(subQuestion);
            } else if (operation == 2) {
                MultiplicationQuestion mulQuestion = new MultiplicationQuestion();
                mulQuestion.setFirstNumber(numberGenerator.getFirstNumber());
                mulQuestion.setSecondNumber(numberGenerator.getSecondNumber());
                questions.add(mulQuestion);
            } else if (operation == 3) {
                DivisionQuestion divQuestion = new DivisionQuestion();
                if (numberGenerator.mostDecimals() > 0) {
                    divQuestion.setFirstNumber(numberGenerator.getFirstNumber());
                    divQuestion.setSecondNumber(numberGenerator.getSecondNumber());
                } else {
                    double[] numbers = numberGenerator.getIntegersForDivQuestion();
                    divQuestion.setFirstNumber(numbers[0]);
                    divQuestion.setSecondNumber(numbers[1]);
                }
                questions.add(divQuestion);
            }

        }

    }

    public static QuizService createQuiz(String[] answers, String[] questions, String userName) {
        QuizService quizService = new QuizService();
        List<Question> questionList = new ArrayList<>();
        User user = new User();
        user.setName(userName);
        for (int i = 0 ; i < answers.length ; i++) {
            Question question = new Question();
            question = Question.parseQuestionString(questions[i]);
            question.setAnswer(Double.parseDouble(answers[i]));
            questionList.add(question);
        }
        quizService.setUser(user);
        quizService.setQuestions(questionList);
        return quizService;
    }

    //get the answer of the user and repeat if when input is not a integer.
    private double getInput() {
        Scanner input = new Scanner(System.in);
        double answer = 0;
        boolean repeat = true;
        do {
            System.out.println("enter your answer");
            try {
                answer = input.nextDouble();
                repeat = false;
            } catch (InputMismatchException e) {
                System.out.println("please enter a integer number");
                input.next();
            }

            return answer;


        } while (repeat);


    }

    //asks the user the questions and enters the input of the user
    public void administrateQuiz() {

        for (int i = lastQuestionNr; i < this.questions.size(); i++) {
            this.startTimes.add(now());
            System.out.println(i + 1 + ") " + this.questions.get(i).getQuestion());
            double answer = getInput();
            this.questions.get(i).setAnswer(answer);
            this.userAnswers.add(answer);
            this.endTimes.add(now());
            Duration questionD = Duration.between(startTimes.get(i), endTimes.get(i));
            this.questions.get(i).setDuration(questionD.toSeconds());
        }
        lastQuestionNr = questions.size();
    }

    //prints the questions of the quiz, the answers of the user, the correct answers and
    //if the answer of the user was correct.
    //also prints how many answers where correct.
    public void gradeQuiz() {
        System.out.printf(CYAN_BOLD + CYAN_UNDERLINED + "%-20s%-20s%-20s%-20s%-20s%n" + RESET,
                "Question", "Your answer", "Correct", "Time", "Result");
        String alternatingColor = "";
        int i = 0;
        String result = "";
        int goodResults = 0;

        Duration totalDuration = Duration.between(startTimes.get(i), endTimes.get(amountQuestions - 1));
        totalTime = totalTime.plus(totalDuration);


        int dec1 = NumberGenerator.numberOfDecimals(questions.get(0).getFirstNumber());
        int dec2 = NumberGenerator.numberOfDecimals(questions.get(0).getSecondNumber());

        int amountOfDecimals = dec1 == 0 && dec2 == 0 ? 0 : 2;

        for (QuizQuestion q : this.questions) {


            if (userAnswers.get(i)
                    .equals(NumberGenerator.decimalPlacesController(q.correctAnswer(), amountOfDecimals))) {
                result = GREEN_BOLD + "correct" + RESET;
                goodResults++;
            } else {
                result = RED + "wrong" + RESET;
            }


            alternatingColor = i % 2 == 0 ? CYAN_BACKGROUND : WHITE;


            Duration questionD = Duration.between(startTimes.get(i), endTimes.get(i));
            String time = questionD.toMinutes() + " min " + questionD.toSecondsPart() + " sec";
            System.out.printf(alternatingColor + "%-20s" +
                            "%-20" + QuizQuestion.floatSwitch(userAnswers.get(i)) + "f" +
                            "%-20" + QuizQuestion.floatSwitch(q.correctAnswer()) + "f" +
                            "%-20s%-20s%n" + RESET,
                    q.getQuestion(), userAnswers.get(i), q.correctAnswer(), time, result);
            i++;
        }


        totalGoodQuestions = goodResults;
        totalQuestions += this.amountQuestions;
        totalPercent = ((double) totalGoodQuestions / (double) totalQuestions) * 100;


        System.out.println("\n" + CYAN_BOLD + "*****TOTAL*****" + RESET);
        System.out.println(CYAN_UNDERLINED + "you have " + totalGoodQuestions +
                " correct answers out of " + totalQuestions + RESET);
        System.out.printf(CYAN_BACKGROUND + "You have: " + GREEN_BOLD + " %.0f %%" + RESET + "%n", totalPercent);
        System.out.println(CYAN_UNDERLINED + "Total time: " + totalTime.toHoursPart() + " hours " +
                totalTime.toMinutesPart() + " min " + totalTime.toSecondsPart() + " sec" + RESET);

    }

    public List<String> gradeQuizToList() {
        List<String> reportList = new ArrayList<>();


              reportList.add(String.format(CYAN_BOLD + CYAN_UNDERLINED + "%-20s%-20s%-20s%-20s%-20s%n" + RESET,
                        "Question", "Your answer", "Correct", "Time", "Result"));

        String alternatingColor = "";
        int i = 0;
        String result = "";
        int goodResults = 0;

        Duration totalDuration = Duration.between(startTimes.get(i), endTimes.get(amountQuestions - 1));
        totalTime = totalTime.plus(totalDuration);


        int dec1 = NumberGenerator.numberOfDecimals(questions.get(0).getFirstNumber());
        int dec2 = NumberGenerator.numberOfDecimals(questions.get(0).getSecondNumber());

        int amountOfDecimals = dec1 == 0 && dec2 == 0 ? 0 : 2;

        for (QuizQuestion q : this.questions) {


            if (userAnswers.get(i)
                    .equals(NumberGenerator.decimalPlacesController(q.correctAnswer(), amountOfDecimals))) {
                result = GREEN_BOLD + "correct" + RESET;
                goodResults++;
            } else {
                result = RED + "wrong" + RESET;
            }


            alternatingColor = i % 2 == 0 ? CYAN_BACKGROUND : WHITE;


            Duration questionD = Duration.between(startTimes.get(i), endTimes.get(i));
            String time = questionD.toMinutes() + " min " + questionD.toSecondsPart() + " sec";
           reportList.add(String.format(alternatingColor + "%-20s" +
                            "%-20" + QuizQuestion.floatSwitch(userAnswers.get(i)) + "f" +
                            "%-20" + QuizQuestion.floatSwitch(q.correctAnswer()) + "f" +
                            "%-20s%-20s%n" + RESET,
                    q.getQuestion(), userAnswers.get(i), q.correctAnswer(), time, result));
            i++;
        }


        totalGoodQuestions = goodResults;
        totalQuestions += this.amountQuestions;
        totalPercent = ((double) totalGoodQuestions / (double) totalQuestions) * 100;


        reportList.add(String.format(CYAN_BOLD + "*****TOTAL*****" + RESET));
        reportList.add(String.format(CYAN_UNDERLINED + "you have " + totalGoodQuestions +
                " correct answers out of " + totalQuestions + RESET));
        reportList.add(String.format(CYAN_BACKGROUND + "You have: " + GREEN_BOLD + " %.0f %%" + RESET + "%n", totalPercent));
        reportList.add(String.format(CYAN_UNDERLINED + "Total time: " + totalTime.toHoursPart() + " hours " +
                totalTime.toMinutesPart() + " min " + totalTime.toSecondsPart() + " sec" + RESET));
        return reportList;
    }

    //inner class that will control the operations of the quiz based on constructor of QuizService
    public class Operations {
        //array of the different operations of the quiz
        //Can be different options depending on what is set when QuizService is initialized
        int[] operations = new int[0];

        public Operations() {

            if (!IsAddition && !IsDivision && !IsMultiplication && !IsSubtraction) {
                IsAddition = true;
            }

            if (IsAddition) {
                addNumberToArr(0);
            }
            if (IsSubtraction) {
                addNumberToArr(1);
            }
            if (IsMultiplication) {
                addNumberToArr(2);
            }
            if (IsDivision) {
                addNumberToArr(3);
            }

        }


        //to print the operations asked by user
        private String operationNames() {
            String operations = "";
            String delimiter = "";
            boolean more = false;
            if (IsAddition) {
                delimiter = more ? ", " : "";
                operations += delimiter + "addition";
                more = true;
            }
            if (IsSubtraction) {
                delimiter = more ? ", " : "";
                operations += delimiter + "subtraction";
                more = true;
            }
            if (IsMultiplication) {
                delimiter = more ? ", " : "";
                operations += delimiter + "multiplication";
                more = true;
            }
            if (IsDivision) {
                delimiter = more ? ", " : "";
                operations += delimiter + "division";
                more = true;
            }
            return operations;
        }

        private void addNumberToArr(int x) {
            this.operations = Arrays.copyOf(this.operations, this.operations.length + 1);
            this.operations[this.operations.length - 1] = x;
        }

    }


}


