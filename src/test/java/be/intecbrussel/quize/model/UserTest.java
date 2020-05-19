package be.intecbrussel.quize.model;

import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

//    @Test
    public void persistUser(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("dataQuiz");
        EntityManager em = factory.createEntityManager();
        User user = new User();
        user.setName("Frits");
//        user.setPassword("123");

        User user1 = em.find(User.class,user.getName());

        System.out.println(user1.getPassword());


        em.close();
        factory.close();

    }

}