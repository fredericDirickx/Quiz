package be.intecbrussel.quize.model;

import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

class QuizServiceTest {

    @Test
    public void testDb(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("datasource");
        NumberGenerator numberGenerator = new NumberGenerator(1,10,1,10);
        QuizService quiz = new QuizService(10,false,false,true,false,numberGenerator);
        quiz.administrateQuiz();

        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(quiz);
        em.getTransaction().commit();

        em.close();
        factory.close();
    }

}