package be.intecbrussel.quize.model;

import be.intecbrussel.quize.service.NumberGeneratorService;
import be.intecbrussel.quize.service.QuizService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

class QuizServiceTest {

//    @Test
    public void testDb(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("datasource");
        NumberGeneratorService numberGenerator = new NumberGeneratorService(1,10,1,10);
        QuizService quiz = new QuizService();
        quiz.setAmountQuestions(10);
        quiz.setIsMultiplication(true);
        quiz.setNumberGenerator(numberGenerator);
        User user = new User();
        user.setName("Frits");
        quiz.setUser(user);
        quiz.createQuestions();

        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(quiz);
        em.persist(user);

        for (Question q : quiz.getQuestions()) {
            em.persist(q);
        }

        em.getTransaction().commit();

        em.close();
        factory.close();
    }

//    @Test
    void testQuestions() {
        NumberGeneratorService numberGenerator = new NumberGeneratorService(1,10,1,10);
        QuizService quiz = new QuizService();
        quiz.setAmountQuestions(10);
        quiz.setIsMultiplication(true);
        quiz.setNumberGenerator(numberGenerator);
        User user = new User();
        user.setName("Frits");
        quiz.setUser(user);
        quiz.createQuestions();
        for (Question q : quiz.getQuestions()) {
            System.out.println(q.getOperator());
        }


    }
}