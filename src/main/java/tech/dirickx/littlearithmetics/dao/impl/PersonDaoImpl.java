package tech.dirickx.littlearithmetics.dao.impl;

import tech.dirickx.littlearithmetics.dao.PersonDao;
import tech.dirickx.littlearithmetics.models.Person;
import tech.dirickx.littlearithmetics.models.User;

import javax.persistence.EntityManager;
import java.util.List;

public class PersonDaoImpl implements PersonDao {

    @Override
    public List getList() {
        EntityManager em = JpaSessionUtil.getEntityManager("dataQuiz");
        em.getTransaction().begin();
        List<Person> userList = em.createQuery("SELECT p FROM Person AS p").getResultList();
        em.close();
        return userList;
    }

    @Override
    public void create(Person person) {

    }

    @Override
    public void delete(Person person) {

    }

    @Override
    public void update(Person person) {

    }
}
