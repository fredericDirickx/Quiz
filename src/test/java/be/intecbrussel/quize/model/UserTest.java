package be.intecbrussel.quize.model;

import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

//    @Test
    public void persistUser(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("datasource");
        EntityManager em = factory.createEntityManager();
        User user = new User();
        user.setName("Frederic");

        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();

        em.close();
        factory.close();

    }

}