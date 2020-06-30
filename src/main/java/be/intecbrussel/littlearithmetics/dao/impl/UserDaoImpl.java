package be.intecbrussel.littlearithmetics.dao.impl;

import be.intecbrussel.littlearithmetics.dao.Dao;
import be.intecbrussel.littlearithmetics.dao.UserDao;
import be.intecbrussel.littlearithmetics.model.User;

import javax.persistence.EntityManager;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List getList() {
        EntityManager em = JpaSessionUtil.getEntityManager("dataQuiz");
        em.getTransaction().begin();
        List<User> userList = em.createQuery("SELECT u FROM User AS u").getResultList();
        em.close();
        return userList;
    }

    @Override
    public void create(User user) {
        EntityManager em = JpaSessionUtil.getEntityManager("dataQuiz");
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }


    public User findByName(String userName) {
        EntityManager em = JpaSessionUtil.getEntityManager("dataQuiz");
        em.getTransaction().begin();
        User foundUser = em.find(User.class, userName);
        em.close();
        return foundUser;
    }

    @Override
    public void delete(User user) {
        EntityManager em = JpaSessionUtil.getEntityManager("dataQuiz");
        em.getTransaction().begin();
        em.remove(em.find(User.class,user.getName()));
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void update(User user) {
        EntityManager em = JpaSessionUtil.getEntityManager("dataQuiz");
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
        em.close();

    }
}
