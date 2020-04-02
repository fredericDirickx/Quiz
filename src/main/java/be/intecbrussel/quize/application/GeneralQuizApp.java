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


        NumberGenerator numberGenerator = new NumberGenerator(0,10,0,11);
        QuizService quizService = null;
            quizService = new QuizService();

            quizService.setAmountQuestions(20);
//            quizService.setMultiplication(true);
            quizService.setDivision(true);
//            quizService.setAddition(true);
//            quizService.setSubtraction(true);
            quizService.setNumberGenerator(numberGenerator);


        User user = new User();
        user.setName(quizService.askUserName());

        quizService.setUser(user);

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


        em.getTransaction().begin();

        User registeredUser = em.find(User.class, user.getName());
        if(registeredUser==null) {
            em.persist(user);
        }else {
            quizService.setUser(registeredUser);
        }

        em.persist(quizService);

        for(Question q : quizService.getQuestions()){
            em.persist(q);
        }

        em.getTransaction().commit();

        em.close();
        factory.close();





        System.out.println("SEE YOU NEXT TIME!!!!!");



    }
}
