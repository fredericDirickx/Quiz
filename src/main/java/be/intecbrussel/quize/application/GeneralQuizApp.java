package be.intecbrussel.quize.application;

import be.intecbrussel.quize.model.NumberGenerator;
import be.intecbrussel.quize.model.Question;
import be.intecbrussel.quize.model.QuizService;
import be.intecbrussel.quize.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class GeneralQuizApp {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("datasource");
        EntityManager em = factory.createEntityManager();

        QuizService quizService = new QuizService();

        NumberGenerator numberGenerator = new NumberGenerator(1, 11, 0, 11);
        quizService.setNumberGenerator(numberGenerator);

        //adding the amount of questions
        quizService.setAmountQuestions(10);

        //set the kind of operations the questions should contain, can be a mix (Uncomment other options if you like)
        quizService.setMultiplication(true);
//            quizService.setDivision(true);
//            quizService.setAddition(true);
//            quizService.setSubtraction(true);

        User user = new User();
        user.setName(quizService.askUserName());
        quizService.setUser(user);

        //start the quiz
        Scanner input = new Scanner(System.in);
        String enGame = "y";


        while (enGame.equals("y")) {

            System.out.println("Welcome to the quiz\n");
            quizService.createQuiz();
            quizService.administrateQuiz();
            quizService.gradeQuiz();

            System.out.println("Do you want to play again? y or n ?");
            enGame = input.next();

        }


        //commit the results to the database
        em.getTransaction().begin();

        User registeredUser = em.find(User.class, user.getName());
        if (registeredUser == null) {
            em.persist(user);
        } else {
            quizService.setUser(registeredUser);
        }

        em.persist(quizService);

        for (Question q : quizService.getQuestions()) {
            em.persist(q);
        }

        em.getTransaction().commit();

        em.close();
        factory.close();


        System.out.println("SEE YOU NEXT TIME!!!!!");


    }
}
